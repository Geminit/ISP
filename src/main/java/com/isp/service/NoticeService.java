package com.isp.service;

import com.isp.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
public interface NoticeService {

    List<Notice> getNoticeAll();

    List<Notice> getNoticeByPage(Map<String, Object> argsMap);        //按页查询学校层次

    List<Notice> getNoticeByName(String name);

    List<Notice> getNoticeById(Integer id);

    Integer getTotalNumber();                                                   //获取总共页数

    void insertNotice(Map<String, Object> argsMap);

    void updateNotice(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
