package com.isp.service;

import com.isp.entity.InfoType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface InfoTypeService {

    List<InfoType> getAll();

    List<InfoType> getInfoTypeByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<InfoType> getInfoTypeByName(String name);

    List<InfoType> getInfoTypeById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertInfoType(Map<String, Object> argsMap);

    void updateInfoType(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
