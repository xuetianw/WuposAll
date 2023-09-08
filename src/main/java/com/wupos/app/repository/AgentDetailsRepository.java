package com.wupos.app.repository;

import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentDetailsRepository extends JpaRepository<AgentDetails, Long> {
    AgentDetails findByAgentCredentials(AgentCredentials agentCredentials);
}
