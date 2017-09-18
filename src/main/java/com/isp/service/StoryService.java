package com.isp.service;

import com.isp.entity.Story;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface StoryService {

    List<Story> getStoryAll();

    List<Story> getStoryByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Story> getStoryByName(String name);

    List<Story> getStoryById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertStory(Map<String, Object> argsMap);

    void updateStory(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
