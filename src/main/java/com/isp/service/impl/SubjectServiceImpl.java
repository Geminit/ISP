package com.isp.service.impl;

import com.isp.dao.SubjectDao;
import com.isp.entity.Subject;
import com.isp.service.SubjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    public List<Subject> getSubjectAll() {
        return subjectDao.getSubjectAll();
    }

    public List<Subject> getSubjectByPage(Map<String, Object> argsMap) {
        List<Subject> list = subjectDao.getSubjectByPage(argsMap);
        return list;
    }

    public List<Subject> getSubjectByName(String name) {
        List<Subject> list = subjectDao.getSubjectByName(name);
        return list;
    }

    public List<Subject> getSubjectById(Integer id) {
        List<Subject> list = subjectDao.getSubjectById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return subjectDao.getTotalNumber();
    }

    public void insertSubject(Map<String, Object> argsMap) {
        subjectDao.insertSubject(argsMap);
    }

    public void updateSubject(Map<String, Object> argsMap) {
        subjectDao.updateSubject(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        subjectDao.deleteById(id);
    }
}
