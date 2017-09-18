package com.isp.service.impl;

import com.isp.dao.TeacherDao;
import com.isp.entity.Teacher;
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
    private TeacherDao gradeDao;

    public List<Teacher> getTeacherAll() {
        return gradeDao.getTeacherAll();
    }

    public List<Teacher> getTeacherByPage(Map<String, Object> argsMap) {
        List<Teacher> list = gradeDao.getTeacherByPage(argsMap);
        return list;
    }

    public List<Teacher> getTeacherByName(String name) {
        List<Teacher> list = gradeDao.getTeacherByName(name);
        return list;
    }

    public List<Teacher> getTeacherById(Integer id) {
        List<Teacher> list = gradeDao.getTeacherById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return gradeDao.getTotalNumber();
    }

    public void insertTeacher(Map<String, Object> argsMap) {
        gradeDao.insertTeacher(argsMap);
    }

    public void updateTeacher(Map<String, Object> argsMap) {
        gradeDao.updateTeacher(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        gradeDao.deleteById(id);
    }
}
