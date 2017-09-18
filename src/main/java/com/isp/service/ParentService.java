package com.isp.service;

import com.isp.entity.Parent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface ParentService {

    List<Parent> getParentByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Parent> getParentByName(String parent_name);

    List<Parent> getParentById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertParent(Map<String, Object> argsMap);

    void updateParent(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
