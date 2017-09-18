package com.isp.service.impl;

import com.isp.dao.SchoolInfoRecordDao;
import com.isp.entity.SchoolInfoRecord;
import com.isp.service.SchoolInfoRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class SchoolInfoRecordServiceImpl implements SchoolInfoRecordService {

    @Autowired
    private SchoolInfoRecordDao schoolInfoRecordDao;

    public List<SchoolInfoRecord> getSchoolInfoRecordAll() {
        return schoolInfoRecordDao.getSchoolInfoRecordAll();
    }

    public List<SchoolInfoRecord> getSchoolInfoRecordByPage(Map<String, Object> argsMap) {
        List<SchoolInfoRecord> list = schoolInfoRecordDao.getSchoolInfoRecordByPage(argsMap);
        return list;
    }

    public List<SchoolInfoRecord> getSchoolInfoRecordByName(String name) {
        List<SchoolInfoRecord> list = schoolInfoRecordDao.getSchoolInfoRecordByName(name);
        return list;
    }

    public List<SchoolInfoRecord> getSchoolInfoRecordById(Integer id) {
        List<SchoolInfoRecord> list = schoolInfoRecordDao.getSchoolInfoRecordById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return schoolInfoRecordDao.getTotalNumber();
    }

    public void insertSchoolInfoRecord(Map<String, Object> argsMap) {
        schoolInfoRecordDao.insertSchoolInfoRecord(argsMap);
    }

    public void updateSchoolInfoRecord(Map<String, Object> argsMap) {
        schoolInfoRecordDao.updateSchoolInfoRecord(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        schoolInfoRecordDao.deleteById(id);
    }
}
