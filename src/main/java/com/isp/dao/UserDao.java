package com.isp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Zhang
 * @create 2016-9-11
 */

@Repository
public interface UserDao {

    List<Object> getUserByPage(Map<String, Object> argsMap);

    List<Object> getUserByAccount(@Param("account")String account);

    List<Object> getUserById(@Param("id")Integer id);

    Integer getTotalNumber();

    void insertUser(Map<String, Object> argsMap);

    void updateUser(Map<String, Object> argsMap);

    void deleteById(@Param("id")Integer id);
}
