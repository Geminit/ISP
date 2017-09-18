package com.isp.dao;

import com.isp.entity.Title;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface TitleDao {

    List<Title> getTitleAll();

    List<Title> getTitleByPage(Map<String, Object> argsMap);

    List<Title> getTitleByName(@Param("name") String name);

    List<Title> getTitleById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertTitle(Map<String, Object> argsMap);

    void updateTitle(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
