package com.isp.dao;

import com.isp.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-18
 */

@Repository
public interface TeacherDao {

    List<String> getRegions();

    List<String> getLevels();

    List<String> getSubjects();

    List<String> getAges();

    List<String> getDiplomas();

    List<String> getTitles();

    int getTeacherNumber();

    Teacher getTeacherById(@Param("teacherId")int id);

    List<Teacher> getAllTeacher();

    List<Teacher> getTeacherBySelection(@Param("region")String region, @Param("level")String level,
                                        @Param("subject")String subject, @Param("age")int age,
                                        @Param("diploma")String diploma, @Param("title")String title);

}
