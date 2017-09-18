package com.isp.dao;

import com.isp.entity.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface SchoolDao {

    List<School> getSchoolAll();

    List<School> getSchoolByPage(Map<String, Object> argsMap);

    List<School> getSchoolByName(@Param("name") String name);

    List<School> getSchoolById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertSchool(Map<String, Object> argsMap);

    void updateSchool(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
