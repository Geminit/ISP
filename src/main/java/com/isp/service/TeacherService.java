package com.isp.service;

import com.isp.entity.Teacher;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-18
 */

public interface TeacherService {

    List<String> getRegions();

    List<String> getLevels();

    List<String> getSubjects();

    List<String> getAges();

    List<String> getDiplomas();

    List<String> getTitles();

    int getTeacherNumber();

    Teacher getTeacherById(int id);

    List<Teacher> getAllTeacher();

    List<Teacher> getTeacherBySelection(String region, String level,String subject,
                                        int age,String diploma, String title);
}
