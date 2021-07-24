package com.lovecoding.web.service.impl;

import com.lovecoding.web.bean.User;
import com.lovecoding.web.dao.UserDao;
import com.lovecoding.web.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private static UserDao userDao;

    static {
        userDao = new UserDao();
    }

    /**
     * 注册用户
     * @param parameterMap
     * @return
     */
    @Override
    public int register(Map<String, String[]> parameterMap) {
        try {
            User user = new User();
            BeanUtils.populate(user , parameterMap);
            user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
            return userDao.register(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
