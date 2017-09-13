package com.isp.service;

import com.isp.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author Geminit
 * @create 2016-9-11
 */

public interface UserService {

    User getUserById(Long userId);

    List<Object> getUserByPage(Map<String, Object> argsMap);
}
