package com.isp.dao;

import com.isp.entity.Region;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface RegionDao {

    List<Region> getRegionAll();

    List<Region> getRegionByPage(Map<String, Object> argsMap);

    List<Region> getRegionByName(@Param("name") String name);

    List<Region> getRegionById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertRegion(Map<String, Object> argsMap);

    void updateRegion(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
