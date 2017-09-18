package com.isp.dao;

import com.isp.entity.NoticeGroupByConcer;
import com.isp.entity.Parent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface ParentDao {

    List<Parent> getParentByPage(Map<String, Object> argsMap);

    List<Parent> getParentByName(@Param("parent_name") String name);

    List<Parent> getParentById(@Param("id") Integer id);

    List<NoticeGroupByConcer> getParenteGroupByConcer();

    Integer getTotalNumber();

    void insertParent(Map<String, Object> argsMap);

    void updateParent(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
