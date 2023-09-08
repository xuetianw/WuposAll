package com.wupos.app.model.agent;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AgentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Embedded
    @JsonProperty("agentName")
    private AgentName Name;

    private String agentCountry;
    @JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
    private LocalDateTime lastLogin;
    @JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
    private LocalDateTime lastLogout;

    @OneToOne
    @JoinColumn(name="username")
    private AgentCredentials agentCredentials;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public AgentCredentials getAgentCredentials() {
        return agentCredentials;
    }

    public void setAgentCredentials(AgentCredentials agentCredentials) {
        this.agentCredentials = agentCredentials;
    }



    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    public AgentName getName() {
        return Name;
    }

    public void setName(AgentName name) {
        Name = name;
    }

    public String getAgentCountry() {
        return agentCountry;
    }

    public void setAgentCountry(String agentCountry) {
        this.agentCountry = agentCountry;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(LocalDateTime lastLogout) {
        this.lastLogout = lastLogout;
    }
}
