package com.isp.service;

import java.util.List;
import java.util.Map;

/**
 * @author Geminit
 * @create 2016-9-11
 */

public interface UserService {

    List<Object> getUserByPage(Map<String, Object> argsMap);

    List<Object> getUserByAccount(String account);

    List<Object> getUserById(Integer id);

    Integer getTotalNumber();

    void insertUser(Map<String, Object> argsMap);

    void updateUser(Map<String, Object> argsMap);

    void deleteById(Integer id);
}
