package com.lovecoding.web.service;

import com.lovecoding.web.bean.User;

import java.util.Map;

public interface UserService {
    int register(Map<String, String[]> parameterMap);

    int checkUserIsExit(String username);

    User login(String username, String password);
}
