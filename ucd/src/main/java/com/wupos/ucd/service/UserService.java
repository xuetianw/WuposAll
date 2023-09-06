package com.wupos.ucd.service;

import com.wupos.ucd.entity.User;

public interface UserService {
    long addOrUpdateUser(User user);
    User getUser(String pcp);
}
