package com.isp.service;

import com.isp.entity.License;
import com.isp.entity.School;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-12
 */

public interface InfoService {

    List<School> getNewSchool();

    List<School> getModifiedSchool();

    List<School> getEndingSchool();

    School getSchoolById(int schoolId);

    License getLicenseById(int licenseId);

}
