package com.wupos.app.model.returningParcingModel;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compliance {
    private String idNumber;

    private String idType;

    private String idIssueDate;

    private String idExpiryDate;


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
