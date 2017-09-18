package com.isp.service.impl;

import com.isp.dao.StoryDao;
import com.isp.entity.Story;
import com.isp.service.StoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryDao gradeDao;

    public List<Story> getStoryAll() {
        return gradeDao.getStoryAll();
    }

    public List<Story> getStoryByPage(Map<String, Object> argsMap) {
        List<Story> list = gradeDao.getStoryByPage(argsMap);
        return list;
    }

    public List<Story> getStoryByName(String name) {
        List<Story> list = gradeDao.getStoryByName(name);
        return list;
    }

    public List<Story> getStoryById(Integer id) {
        List<Story> list = gradeDao.getStoryById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return gradeDao.getTotalNumber();
    }

    public void insertStory(Map<String, Object> argsMap) {
        gradeDao.insertStory(argsMap);
    }

    public void updateStory(Map<String, Object> argsMap) {
        gradeDao.updateStory(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        gradeDao.deleteById(id);
    }
}
