package com.isp.dao;

import com.isp.entity.License;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface LicenseDao {

    List<License> getLicenseAll();

    List<License> getLicenseByPage1(Map<String, Object> argsMap);

    List<License> getLicenseByName(@Param("name") String name);

    List<License> getLicenseById1(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertLicense(Map<String, Object> argsMap);

    void updateLicense(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
