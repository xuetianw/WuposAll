package com.wupos.app.service;

import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;

public interface LoginService {
    AgentDetails login(AgentCredentials agentCredentials);
}
