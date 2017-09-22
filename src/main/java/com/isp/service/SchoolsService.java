package com.isp.service;

import com.isp.entity.School;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-14
 */

public interface SchoolsService {

    int getGoodSchoolNumber();

    School getSchoolById(int schoolId);

    List<String> getAllSchool();

    List<School> getSchoolPhone();

    List<School> getGoodSchoolByPage(int page);

}
