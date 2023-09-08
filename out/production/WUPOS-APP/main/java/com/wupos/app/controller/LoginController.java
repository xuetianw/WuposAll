package com.wupos.app.controller;

import com.wupos.app.exceptions.AgentNotFoundException;
import com.wupos.app.exceptions.WrongPasswordException;
import com.wupos.app.model.AgentEntity;
import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import com.wupos.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class LoginController {

    @Autowired
    private LoginService loginService; // no service created yet

    @PostMapping("/login")
    public ResponseEntity<AgentDetails> login(@RequestBody AgentCredentials agentCredentials) {
        AgentDetails loggedInUser = loginService.login(agentCredentials);
        return ResponseEntity.ok(loggedInUser);
    }

    @PostMapping("/password")
    public String generatePassword(@RequestBody String plainText){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        return bCrypt.encode(plainText);
    }


    @GetMapping
    public List<AgentEntity> getAllAgents() {
        return loginService.getAllAgents();
    }

    @PostMapping("/createAgent")
    public AgentEntity createAgent(@RequestBody AgentEntity agent) {
        return loginService.createAgent(agent);
    }

    @GetMapping("/{id}")
    public AgentEntity getAgentById(@PathVariable Long id) {
        return loginService.getAgentById(id);
    }

    @PutMapping("/{id}")
    public AgentEntity updateAgent(@PathVariable Long id, @RequestBody AgentEntity agent) {
        return loginService.updateAgent(id, agent);
    }

    @DeleteMapping("/{id}")
    public void deleteAgent(@PathVariable Long id) {
        loginService.deleteAgent(id);
    }
}
