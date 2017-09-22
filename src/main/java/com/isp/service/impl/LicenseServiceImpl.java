package com.isp.service.impl;

import com.isp.dao.LicenseDao;
import com.isp.entity.License;
import com.isp.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-15
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    LicenseDao licenseDao;

    public int getLicenseNumber(){ return licenseDao.getLicenseNumber(); };

    public License getLiceseById(int id){ return licenseDao.getLicenseById(id); };

    public List<License> getLicenseByPage(int page){ return licenseDao.getLicenseByPage(page); };

}
