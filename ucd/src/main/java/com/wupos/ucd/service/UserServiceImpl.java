package com.wupos.ucd.service;

import com.wupos.ucd.entity.*;
import com.wupos.ucd.repository.ComplianceRepository;
import com.wupos.ucd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComplianceRepository complianceRepository;

    private void saveUser(Customer savedUser,
        Customer user, 
        UserRepository userRepository, 
        ComplianceRepository complianceRepository) {
            savedUser.setName(user.getName());
            savedUser.setPhoneNumber(user.getPhoneNumber());
            savedUser.setAddress(user.getAddress());
            savedUser.setCompliance(user.getCompliance());
            userRepository.save(savedUser);
            complianceRepository.save(user.getCompliance());
    }

    @Override
    public long addOrUpdateUser(Customer user) {
        System.out.println("user: " + user);
        System.out.println(user.getPcp());
        Customer savedUser = userRepository.findByPcp(user.getPcp());
        long pcp;

        if (savedUser != null) {
            saveUser(savedUser, user, userRepository, complianceRepository);
            pcp = 0;
        } else {
            savedUser = new Customer();
            saveUser(savedUser, user, userRepository, complianceRepository);
            pcp = savedUser.getPcp();
        }
        return pcp;
    }

    @Override
    public Customer getUser(String pcp) {
        try {
            return userRepository.findById(pcp).orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
