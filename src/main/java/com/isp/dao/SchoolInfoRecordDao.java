package com.isp.dao;

import com.isp.entity.SchoolInfoRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface SchoolInfoRecordDao {

    List<SchoolInfoRecord> getSchoolInfoRecordAll();

    List<SchoolInfoRecord> getSchoolInfoRecordByPage(Map<String, Object> argsMap);

    List<SchoolInfoRecord> getSchoolInfoRecordByName(@Param("name") String name);

    List<SchoolInfoRecord> getSchoolInfoRecordById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertSchoolInfoRecord(Map<String, Object> argsMap);

    void updateSchoolInfoRecord(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
