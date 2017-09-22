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

    int getGoodSchoolNumber();

    List<String> getAllSchool();

    List<School> getGoodSchoolByPage(@Param("page")int page);

    List<School> getSchoolPhone();

    School getSchoolById(@Param("schoolId")int schoolId);

}
