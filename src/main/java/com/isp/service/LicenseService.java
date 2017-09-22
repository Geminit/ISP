package com.isp.service;

import com.isp.entity.License;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-15
 */

public interface LicenseService {

    int getLicenseNumber();

    License getLiceseById(int id);

    List<License> getLicenseByPage(int page);

}
