package com.isp.dao;

import com.isp.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface SubjectDao {

    List<Subject> getSubjectAll();

    List<Subject> getSubjectByPage(Map<String, Object> argsMap);

    List<Subject> getSubjectByName(@Param("name") String name);

    List<Subject> getSubjectById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertSubject(Map<String, Object> argsMap);

    void updateSubject(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
