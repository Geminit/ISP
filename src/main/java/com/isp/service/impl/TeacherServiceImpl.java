package com.isp.service.impl;

import com.isp.dao.TeacherDao;
import com.isp.entity.Teacher;
import com.isp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-14
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<String> getRegions(){ return teacherDao.getRegions(); };

    public List<String> getLevels(){ return teacherDao.getLevels(); };

    public List<String> getSubjects(){ return teacherDao.getSubjects(); };

    public List<String> getAges(){ return teacherDao.getAges(); };

    public List<String> getDiplomas(){ return teacherDao.getDiplomas(); };

    public List<String> getTitles(){ return teacherDao.getTitles(); };

    public int getTeacherNumber(){ return teacherDao.getTeacherNumber(); }

    public Teacher getTeacherById(int id){ return teacherDao.getTeacherById(id); }

    public List<Teacher> getAllTeacher(){ return teacherDao.getAllTeacher(); }

    public List<Teacher> getTeacherBySelection(String region, String level, String subject,
                                               int age, String diploma, String title){
        return teacherDao.getTeacherBySelection(region, level, subject, age, diploma, title);
    }

}
