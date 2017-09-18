package com.isp.service.impl;

import com.isp.dao.SchoolDao;
import com.isp.entity.PrimaryStudentBySchool;
import com.isp.entity.School;
import com.isp.service.SchoolService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    public List<School> getSchoolAll() {
        return schoolDao.getSchoolAll();
    }

    public List<School> getSchoolByPage(Map<String, Object> argsMap) {
        List<School> list = schoolDao.getSchoolByPage(argsMap);
        return list;
    }

    public List<School> getSchoolByName(String name) {
        List<School> list = schoolDao.getSchoolByName(name);
        return list;
    }

    public List<School> getSchoolById(Integer id) {
        List<School> list = schoolDao.getSchoolById(id);
        return list;
    }

    public List<School> getSchoolName() {
        return schoolDao.getSchoolName();
    }

    public List<PrimaryStudentBySchool> primaryStudentBySchool() {
        return schoolDao.primaryStudentBySchool();
    }

    public Integer getTotalNumber() {
        return schoolDao.getTotalNumber();
    }

    public void insertSchool(Map<String, Object> argsMap) {
        schoolDao.insertSchool(argsMap);
    }

    public void updateSchool(Map<String, Object> argsMap) {
        schoolDao.updateSchool(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        schoolDao.deleteById(id);
    }
}
