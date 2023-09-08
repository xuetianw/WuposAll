package com.wupos.app.repo;

import com.wupos.app.model.AgentEntity;
import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentDetailsRepository extends JpaRepository<AgentDetails, Long> {
    AgentDetails findByAgentCredentials(AgentCredentials agentCredentials);
}
