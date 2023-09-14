package com.wupos.ucd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wupos.ucd.entity.Compliance;
import com.wupos.ucd.repository.UserRepository;

@Service
public class ComplianceServiceImpl implements ComplianceService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Compliance getCompliance(String pcp) {
        try {
            long pcpLong = Long.parseLong(pcp);
            return userRepository.findComplianceByPcp(pcpLong);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
