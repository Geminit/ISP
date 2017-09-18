package com.isp.service;

import com.isp.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface GradeService {

    List<Grade> getGradeAll();

    List<Grade> getGradeByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Grade> getGradeByName(String name);

    List<Grade> getGradeById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertGrade(Map<String, Object> argsMap);

    void updateGrade(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
