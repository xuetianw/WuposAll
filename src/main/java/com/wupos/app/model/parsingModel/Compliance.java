package com.wupos.app.model.parsingModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Compliance {

    private String idType;
    private String idNumber;
    private String idIssueDate;
    private String idExpiryDate;

}
