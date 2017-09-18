package com.isp.service;

import com.isp.entity.SchoolInfoRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface SchoolInfoRecordService {

    List<SchoolInfoRecord> getSchoolInfoRecordAll();

    List<SchoolInfoRecord> getSchoolInfoRecordByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<SchoolInfoRecord> getSchoolInfoRecordByName(String name);

    List<SchoolInfoRecord> getSchoolInfoRecordById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertSchoolInfoRecord(Map<String, Object> argsMap);

    void updateSchoolInfoRecord(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
