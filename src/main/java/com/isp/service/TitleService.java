package com.isp.service;

import com.isp.entity.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface TitleService {

    List<Title> getTitleAll();

    List<Title> getTitleByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Title> getTitleByName(String name);

    List<Title> getTitleById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertTitle(Map<String, Object> argsMap);

    void updateTitle(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
