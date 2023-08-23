package com.wupos.app.parsingModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Compliance {

    private String idType;
    private String idNumber;
    private String idIssueDate;
    private String idExpiryDate;

}
