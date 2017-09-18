package com.isp.service;

import com.isp.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface TeacherService {

    List<Teacher> getTeacherAll();

    List<Teacher> getTeacherByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Teacher> getTeacherByName(String name);

    List<Teacher> getTeacherById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertTeacher(Map<String, Object> argsMap);

    void updateTeacher(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
