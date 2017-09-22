package com.isp.service;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-12
 */

public interface DataService {

    int getTotleSchoolNumberByRegion(String region);

    List<String> getAllRegion();

    List<String> getAllLevel();

    int getSchoolNumberByRegionAndLevel(String region,String level);

}
