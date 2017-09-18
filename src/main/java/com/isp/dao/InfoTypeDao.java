package com.isp.dao;

import com.isp.entity.InfoType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface InfoTypeDao {

    List<InfoType> getAll();

    List<InfoType> getInfoTypeByPage(Map<String, Object> argsMap);

    List<InfoType> getInfoTypeByName(@Param("name") String name);

    List<InfoType> getInfoTypeById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertInfoType(Map<String, Object> argsMap);

    void updateInfoType(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
