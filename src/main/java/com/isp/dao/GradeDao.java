package com.isp.dao;

import com.isp.entity.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface GradeDao {

    List<Grade> getGradeAll();

    List<Grade> getGradeByPage(Map<String, Object> argsMap);

    List<Grade> getGradeByName(@Param("name") String name);

    List<Grade> getGradeById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertGrade(Map<String, Object> argsMap);

    void updateGrade(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
