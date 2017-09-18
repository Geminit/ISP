package com.isp.service.impl;

import com.isp.dao.TeacherDao;
import com.isp.entity.Teacher;
import com.isp.entity.TeacherGroupByMonth;
import com.isp.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> getTeacherAll() {
        return teacherDao.getTeacherAll();
    }

    public List<Teacher> getTeacherByPage(Map<String, Object> argsMap) {
        List<Teacher> list = teacherDao.getTeacherByPage(argsMap);
        return list;
    }

    public List<Teacher> getTeacherByName(String name) {
        List<Teacher> list = teacherDao.getTeacherByName(name);
        return list;
    }

    public List<Teacher> getTeacherById(Integer id) {
        List<Teacher> list = teacherDao.getTeacherById(id);
        return list;
    }

    public List<TeacherGroupByMonth> getTeacherGroupByMonth() {
        List<TeacherGroupByMonth> list = teacherDao.getTeacherGroupByMonth();
        return list;
    }

    public Integer getTotalNumber() {
        return teacherDao.getTotalNumber();
    }

    public Integer getReallyTeacherNumber() {
        return teacherDao.getReallyTeacherNumber();
    }

    public Integer getPrimaryTeacherNumber() {
        return teacherDao.getPrimaryTeacherNumber();
    }

    public void insertTeacher(Map<String, Object> argsMap) {
        teacherDao.insertTeacher(argsMap);
    }

    public void updateTeacher(Map<String, Object> argsMap) {
        teacherDao.updateTeacher(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        teacherDao.deleteById(id);
    }
}
