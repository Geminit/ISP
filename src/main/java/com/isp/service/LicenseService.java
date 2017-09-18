package com.isp.service;

import com.isp.entity.License;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface LicenseService {

    List<License> getLicenseAll();

    List<License> getLicenseByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<License> getLicenseByName(String name);

    List<License> getLicenseById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertLicense(Map<String, Object> argsMap);

    void updateLicense(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
