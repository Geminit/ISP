package com.isp.dao;

import com.isp.entity.Notice;
import com.isp.entity.NoticeGroupByConcer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Repository
public interface NoticeDao {

    List<Notice> getNoticeAll();

    List<Notice> getNoticeByPage(Map<String, Object> argsMap);

    List<Notice> getNoticeByName(@Param("name") String name);

    List<Notice> getNoticeById(@Param("id") Integer id);

    List<NoticeGroupByConcer> getNoticeGroupByMonth(@Param("year") Integer year);

    Integer getTotalNumber();

    void insertNotice(Map<String, Object> argsMap);

    void updateNotice(Map<String, Object> argsMap);

    void deleteById(@Param("id") Integer id);
}
