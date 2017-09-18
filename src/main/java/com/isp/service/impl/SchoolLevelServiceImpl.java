package com.isp.service.impl;

import com.isp.dao.SchoolLevelDao;
import com.isp.entity.SchoolLevel;
import com.isp.service.SchoolLevelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class SchoolLevelServiceImpl implements SchoolLevelService {

    @Autowired
    private SchoolLevelDao schoolLevelDao;

    public List<SchoolLevel> getSchoolLevelAll() {
        return schoolLevelDao.getSchoolLevelAll();
    }

    public List<SchoolLevel> getSchoolLevelByPage(Map<String, Object> argsMap) {
        List<SchoolLevel> list = schoolLevelDao.getSchoolLevelByPage(argsMap);
        return list;
    }

    public List<SchoolLevel> getSchoolLevelByName(String name) {
        List<SchoolLevel> list = schoolLevelDao.getSchoolLevelByName(name);
        return list;
    }

    public List<SchoolLevel> getSchoolLevelById(Integer id) {
        List<SchoolLevel> list = schoolLevelDao.getSchoolLevelById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return schoolLevelDao.getTotalNumber();
    }

    public void insertSchoolLevel(Map<String, Object> argsMap) {
        schoolLevelDao.insertSchoolLevel(argsMap);
    }

    public void updateSchoolLevel(Map<String, Object> argsMap) {
        schoolLevelDao.updateSchoolLevel(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        schoolLevelDao.deleteById(id);
    }
}
