package com.isp.dao;

import com.isp.entity.SchoolLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface SchoolLevelDao {

    List<SchoolLevel> getSchoolLevelByPage(Map<String, Object> argsMap);

    List<SchoolLevel> getSchoolLevelByName(@Param("name")String name);

    List<SchoolLevel> getSchoolLevelById(@Param("id")Integer id);

    Integer getTotalNumber();

    void insertSchoolLevel(Map<String, Object> argsMap);

    void updateSchoolLevel(Map<String, Object> argsMap);

    void deleteById(@Param("id")Integer id);
}
