package com.isp.dao;

import com.isp.entity.School;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-15
 */

@Repository
public interface InfoDao {

    List<School> getNewSchool();

    List<School> getModifiedSchool();

    List<School> getEndingSchool();

}
