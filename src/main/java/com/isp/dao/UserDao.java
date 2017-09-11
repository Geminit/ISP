package com.isp.dao;

import com.isp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Geminit
 * @create 2016-9-11
 */

@Repository
public interface UserDao {

    User selectUserById(@Param("userId") Long userId);

}
