package com.isp.service.impl;

import com.isp.dao.DataDao;
import com.isp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-12
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class DataServiceImpl implements DataService {

    @Autowired
    DataDao dataDao;

    public int getTotleSchoolNumberByRegion(String region){ return dataDao.getTotleSchoolNumberByRegion(region); }

    public List<String> getAllRegion(){ return dataDao.getAllRegion(); }

    public List<String> getAllLevel(){ return dataDao.getAllLevel(); }

    public int getSchoolNumberByRegionAndLevel(String region,String level){
        return dataDao.getSchoolNumberByRegionAndLevel(region, level);
    }

}
