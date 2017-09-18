package com.isp.service;

import com.isp.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface SubjectService {

    List<Subject> getSubjectAll();

    List<Subject> getSubjectByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Subject> getSubjectByName(String name);

    List<Subject> getSubjectById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertSubject(Map<String, Object> argsMap);

    void updateSubject(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
