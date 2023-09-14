package com.wupos.ucd.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compliance")
public class Compliance {
    @Id
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "id_type")
    private String idType;
    @Column(name = "id_issue_date")
    private String idIssueDate;
    @Column(name = "id_expiry_date")
    private String idExpiryDate;

    public Compliance() {
    }

    public Compliance(String idType, String idIssueDate, String idExpiryDate) {
        this.idType = idType;
        this.idIssueDate = idIssueDate;
        this.idExpiryDate = idExpiryDate;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdIssueDate() {
        return idIssueDate;
    }

    public void setIdIssueDate(String idIssueDate) {
        this.idIssueDate = idIssueDate;
    }

    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(String idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    @Override
    public String toString() {
        return "Compliance{" +
                "idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", idIssueDate='" + idIssueDate + '\'' +
                ", idExpiryDate='" + idExpiryDate + '\'' +
                '}';
    }
}
