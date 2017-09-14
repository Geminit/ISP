package com.isp.dao;

import com.isp.entity.License;
import com.isp.entity.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-11
 */

@Repository
public interface SchoolDao {

    List<School> getNewSchool();

    List<School> getModifiedSchool();

    List<School> getEndingSchool();

    School getSchoolById(@Param("schoolId")int schoolId);

    License getLicenseById(@Param("licenseId")int licenseId);

}
