package com.isp.service.impl;

import com.isp.dao.LicenseDao;
import com.isp.entity.License;
import com.isp.service.LicenseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    private LicenseDao licenseDao;

    public List<License> getLicenseAll() {
        return licenseDao.getLicenseAll();
    }

    public List<License> getLicenseByPage(Map<String, Object> argsMap) {
        List<License> list = licenseDao.getLicenseByPage(argsMap);
        return list;
    }

    public List<License> getLicenseByName(String name) {
        List<License> list = licenseDao.getLicenseByName(name);
        return list;
    }

    public List<License> getLicenseById(Integer id) {
        List<License> list = licenseDao.getLicenseById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return licenseDao.getTotalNumber();
    }

    public void insertLicense(Map<String, Object> argsMap) {
        licenseDao.insertLicense(argsMap);
    }

    public void updateLicense(Map<String, Object> argsMap) {
        licenseDao.updateLicense(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        licenseDao.deleteById(id);
    }
}
