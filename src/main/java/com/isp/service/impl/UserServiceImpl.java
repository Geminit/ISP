package com.isp.service.impl;

import com.isp.dao.UserDao;
import com.isp.entity.User;
import com.isp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Geminit
 * @create 2016-9-11
 */

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }

    public List<Object> getUserByPage(Map<String, Object> argsMap) {
        List<Object> result = userDao.getUserByPage(argsMap);
        return result;
    }
}
