package com.wupos.app.repository;

import com.wupos.app.model.agent.AgentCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentCredentialsRepository extends JpaRepository<AgentCredentials, String> {
}
