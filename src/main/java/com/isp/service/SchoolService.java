package com.isp.service;

import com.isp.entity.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface SchoolService {

    List<School> getSchoolAll();

    List<School> getSchoolByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<School> getSchoolByName(String name);

    List<School> getSchoolById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertSchool(Map<String, Object> argsMap);

    void updateSchool(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
