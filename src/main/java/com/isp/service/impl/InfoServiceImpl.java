package com.isp.service.impl;

import com.isp.dao.SchoolDao;
import com.isp.entity.License;
import com.isp.entity.School;
import com.isp.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-12
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class InfoServiceImpl implements InfoService {

    @Autowired
    private SchoolDao schoolDao;

    public List<School> getNewSchool(){ return schoolDao.getNewSchool(); }

    public List<School> getModifiedSchool(){ return schoolDao.getModifiedSchool(); }

    public List<School> getEndingSchool(){ return schoolDao.getEndingSchool(); }

    public School getSchoolById(int schoolId){ return schoolDao.getSchoolById(schoolId);};

    public License getLicenseById(int licenseId) { return schoolDao.getLicenseById(licenseId); }
}
