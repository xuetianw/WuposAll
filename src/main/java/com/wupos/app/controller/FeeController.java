package com.wupos.app.controller;


import com.wupos.app.model.getFees.requestParcingModel.FeeRequest;
import com.wupos.app.model.getFees.returningParcingModel.Fee;
import com.wupos.app.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeeController {


    FeeService feeService;


    @Autowired
    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @PostMapping("getFees")
    public Fee getFees(@RequestBody FeeRequest feeRequest) {
        return feeService.getFee(feeRequest);
    }
}
