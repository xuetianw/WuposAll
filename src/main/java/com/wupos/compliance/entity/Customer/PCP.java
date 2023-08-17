package com.wupos.compliance.entity.Customer;

@Entity
public class PCP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pcpCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPcpCode() {
        return pcpCode;
    }

    public void setPcpCode(String pcpCode) {
        this.pcpCode = pcpCode;
    }
}