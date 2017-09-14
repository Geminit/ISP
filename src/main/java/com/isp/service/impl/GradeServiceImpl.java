package com.isp.service.impl;

import com.isp.dao.GradeDao;
import com.isp.entity.Grade;
import com.isp.service.GradeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    public List<Grade> getGradeByPage(Map<String, Object> argsMap) {
        List<Grade> list = gradeDao.getGradeByPage(argsMap);
        return list;
    }

    public List<Grade> getGradeByName(String name) {
        List<Grade> list = gradeDao.getGradeByName(name);
        return list;
    }

    public List<Grade> getGradeById(Integer id) {
        List<Grade> list = gradeDao.getGradeById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return gradeDao.getTotalNumber();
    }

    public void insertGrade(Map<String, Object> argsMap) {
        gradeDao.insertGrade(argsMap);
    }

    public void updateGrade(Map<String, Object> argsMap) {
        gradeDao.updateGrade(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        gradeDao.deleteById(id);
    }
}
