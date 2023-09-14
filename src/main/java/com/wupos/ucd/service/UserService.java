package com.wupos.ucd.service;

import com.wupos.ucd.entity.Customer;

public interface UserService {
    long addOrUpdateUser(Customer user);
    Customer getUser(String pcp);
}
