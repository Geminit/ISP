package com.isp.service.impl;

import com.isp.dao.SchoolDao;
import com.isp.entity.School;
import com.isp.service.SchoolsService;
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
public class SchoolsServiceImpl implements SchoolsService {

    @Autowired
    private SchoolDao schoolDao;

    public int getGoodSchoolNumber(){ return schoolDao.getGoodSchoolNumber(); }

    public List<String> getAllSchool(){ return schoolDao.getAllSchool(); }

    public School getSchoolById(int schoolId){ return schoolDao.getSchoolById(schoolId);};

    public List<School> getSchoolPhone(){ return schoolDao.getSchoolPhone(); };

    public List<School> getGoodSchoolByPage(int page) { return schoolDao.getGoodSchoolByPage(page); }
}
