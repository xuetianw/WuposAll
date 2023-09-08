package com.wupos.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import jakarta.persistence.Entity;

public class AgentEntity {
    // wrapper class

    private AgentCredentials agentCredentials;
    private AgentDetails agentDetails;

    public AgentCredentials getAgentCredentials() {
        return agentCredentials;
    }

    public void setAgentCredentials(AgentCredentials agentCredentials) {
        this.agentCredentials = agentCredentials;
    }

    public AgentDetails getAgentDetails() {
        return agentDetails;
    }

    public void setAgentDetails(AgentDetails agentDetails) {
        this.agentDetails = agentDetails;
    }
}
