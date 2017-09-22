package com.isp.dao;

import com.isp.entity.License;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-11
 */

@Repository
public interface LicenseDao {

    int getLicenseNumber();

    License getLicenseById(@Param("licenseId") int id);

    List<License> getLicenseByPage(@Param("page")int page);

}
