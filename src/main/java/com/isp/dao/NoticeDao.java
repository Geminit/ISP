package com.isp.dao;

import com.isp.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-11
 */

@Repository
public interface NoticeDao {

    int getNoticeNumber();

    List<Notice> getNoticeByPage(@Param("page")int page);

    Notice getNoticeById(@Param("noticeId")int noticeId);

}
