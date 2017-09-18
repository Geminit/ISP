package com.isp.service.impl;

import com.isp.dao.RegionDao;
import com.isp.entity.Region;
import com.isp.service.RegionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;

    public List<Region> getRegionAll() {
        return regionDao.getRegionAll();
    }

    public List<Region> getRegionByPage(Map<String, Object> argsMap) {
        List<Region> list = regionDao.getRegionByPage(argsMap);
        return list;
    }

    public List<Region> getRegionByName(String name) {
        List<Region> list = regionDao.getRegionByName(name);
        return list;
    }

    public List<Region> getRegionById(Integer id) {
        List<Region> list = regionDao.getRegionById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return regionDao.getTotalNumber();
    }

    public void insertRegion(Map<String, Object> argsMap) {
        regionDao.insertRegion(argsMap);
    }

    public void updateRegion(Map<String, Object> argsMap) {
        regionDao.updateRegion(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        regionDao.deleteById(id);
    }
}
