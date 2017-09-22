package com.isp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-21
 */

@Repository
public interface InvestigationDao {

    List<String> getAllFocus();

    void putUpInvestigation(@Param("name")String name, @Param("phone")String phone, @Param("email")String email,
                            @Param("focus")String focus, @Param("bestSchool")String bestSchool,
                            @Param("bestReason")String bestReason, @Param("badestSchool")String badestSchool,
                            @Param("badestReason")String badestReason, @Param("advise")String advise);

}
