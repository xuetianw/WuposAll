package com.wupos.compliance.model.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Compliance {

    @Column
    private String idType;
    @Column
    private String idNumber;
    @Column
    private String idIssueDate;
    @Column
    private String idExpiryDate;


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
}