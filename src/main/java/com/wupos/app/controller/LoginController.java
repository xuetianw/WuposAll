package com.wupos.app.controller;

import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import com.wupos.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<AgentDetails> login(@RequestBody AgentCredentials agentCredentials) {
        AgentDetails loggedInUser = loginService.login(agentCredentials);
        return ResponseEntity.ok(loggedInUser);
    }
}
