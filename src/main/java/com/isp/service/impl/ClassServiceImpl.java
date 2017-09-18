package com.isp.service.impl;

import com.isp.dao.ClassDao;
import com.isp.entity.Class;
import com.isp.service.ClassService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    public List<Class> getClassAll() {
        return classDao.getClassAll();
    }

    public List<Class> getClassByPage(Map<String, Object> argsMap) {
        List<Class> list = classDao.getClassByPage(argsMap);
        return list;
    }

    public List<Class> getClassByName(String name) {
        List<Class> list = classDao.getClassByName(name);
        return list;
    }

    public List<Class> getClassById(Integer id) {
        List<Class> list = classDao.getClassById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return classDao.getTotalNumber();
    }

    public Integer getGraduateNumber() {
        return classDao.getGraduateNumber();
    }

    public Integer getGraduateTotalNumber() {
        return classDao.getGraduateTotalNumber();
    }

    public Double averageNumber() {
        return classDao.averageNumber();
    }

    public void insertClass(Map<String, Object> argsMap) {
        classDao.insertClass(argsMap);
    }

    public void updateClass(Map<String, Object> argsMap) {
        classDao.updateClass(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        classDao.deleteById(id);
    }
}
