package com.isp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-21
 */

@Repository
public interface DataDao {

    int getTotleSchoolNumberByRegion(@Param("region")String region);

    List<String> getAllRegion();

    List<String> getAllLevel();

    int getSchoolNumberByRegionAndLevel(@Param("region")String region,@Param("level")String level);

}
