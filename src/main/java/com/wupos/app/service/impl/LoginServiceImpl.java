package com.wupos.app.service.impl;

import com.wupos.app.exceptions.AgentNotFoundException;
import com.wupos.app.exceptions.WrongPasswordException;
import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import com.wupos.app.repository.AgentCredentialsRepository;
import com.wupos.app.repository.AgentDetailsRepository;
import com.wupos.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AgentCredentialsRepository agentCredentialsRepository;
    @Autowired
    private AgentDetailsRepository agentDetailsRepository;
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
}
