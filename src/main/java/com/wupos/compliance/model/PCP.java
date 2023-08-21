package com.wupos.compliance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="PCP")
@Embeddable
public class PCP {

    @Id
    @Column(name = "PCP")
    @JsonProperty("PCP")
    private String pcp;



    public String getPcpCode() {
        return pcp;
    }

    public void setPcpCode(String pcpCode) {
        this.pcp = pcpCode;
    }

}
