package com.isp.dao;

import com.isp.entity.Story;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface StoryDao {

    List<Story> getStoryAll();

    List<Story> getStoryByPage(Map<String, Object> argsMap);

    List<Story> getStoryByName(@Param("name") String name);

    List<Story> getStoryById(@Param("id") Integer id);

    Integer getTotalNumber();

    void insertStory(Map<String, Object> argsMap);

    void updateStory(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
