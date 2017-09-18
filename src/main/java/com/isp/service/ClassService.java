package com.isp.service;

import com.isp.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface ClassService {

    List<Class> getClassAll();

    List<Class> getClassByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Class> getClassByName(String name);

    List<Class> getClassById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertClass(Map<String, Object> argsMap);

    void updateClass(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
