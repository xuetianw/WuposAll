package com.wupos.app.service;

import com.wupos.app.exceptions.AgentNotFoundException;
import com.wupos.app.exceptions.WrongPasswordException;
import com.wupos.app.model.AgentEntity;
import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import com.wupos.app.repo.AgentCredentialsRepository;
import com.wupos.app.repo.AgentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private AgentDetailsRepository agentDetailsRepository;
    @Autowired
    private AgentCredentialsRepository agentCredentialsRepository;

    public AgentDetails login(AgentCredentials agentCredentials) {
        Optional<AgentCredentials> credentials = agentCredentialsRepository.findById(agentCredentials.getUsername());

        if (credentials.isEmpty()) {
            throw new AgentNotFoundException("Username not found");
        }

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        AgentCredentials dbCredentials = credentials.get();

        if (!bcrypt.matches(agentCredentials.getPassword(), dbCredentials.getPassword())) {
            throw new WrongPasswordException("Username and password did not match");
        }
        AgentDetails details = agentDetailsRepository.findByAgentCredentials(agentCredentials);
        LocalDateTime now = LocalDateTime.now();
        details.setLastLogin(now);
        agentDetailsRepository.save(details);

        return details;
    }




    public List<AgentEntity> getAllAgents() {
        return null;
    }

    public AgentEntity createAgent(AgentEntity agent) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(agent.getAgentCredentials().getPassword());
        agent.getAgentCredentials().setPassword(encodedPassword);
        agentCredentialsRepository.save(agent.getAgentCredentials());
        agentDetailsRepository.save(agent.getAgentDetails());
        return agent;
    }

    public AgentEntity getAgentById(Long id) {
        return null;
    }

    public AgentEntity updateAgent(Long id, AgentEntity agent) {
        return null;
    }

    public void deleteAgent(Long id) {

    }
}
