package com.isp.dao;

import com.isp.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface TeacherDao {

    List<Teacher> getTeacherAll();

    List<Teacher> getTeacherByPage(Map<String, Object> argsMap);

    List<Teacher> getTeacherByName(@Param("name") String name);

    List<Teacher> getTeacherById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertTeacher(Map<String, Object> argsMap);

    void updateTeacher(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
