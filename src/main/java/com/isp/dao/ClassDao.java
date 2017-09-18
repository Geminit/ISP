package com.isp.dao;

import com.isp.entity.Class;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface ClassDao {

    List<Class> getClassAll();

    List<Class> getClassByPage(Map<String, Object> argsMap);

    List<Class> getClassByName(@Param("name") String name);

    List<Class> getClassById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertClass(Map<String, Object> argsMap);

    void updateClass(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
