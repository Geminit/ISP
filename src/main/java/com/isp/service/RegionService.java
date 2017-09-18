package com.isp.service;

import com.isp.entity.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface RegionService {

    List<Region> getRegionAll();

    List<Region> getRegionByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Region> getRegionByName(String name);

    List<Region> getRegionById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertRegion(Map<String, Object> argsMap);

    void updateRegion(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
