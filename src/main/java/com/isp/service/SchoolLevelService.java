package com.isp.service;

import com.isp.entity.SchoolLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface SchoolLevelService {

    List<SchoolLevel> getSchoolLevelAll();

    List<SchoolLevel> getSchoolLevelByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<SchoolLevel> getSchoolLevelByName(String name);

    List<SchoolLevel> getSchoolLevelById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertSchoolLevel(Map<String, Object> argsMap);

    void updateSchoolLevel(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
