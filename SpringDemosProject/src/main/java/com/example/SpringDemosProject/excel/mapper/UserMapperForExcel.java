package com.example.SpringDemosProject.excel.mapper;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/11/21 22:37:51
 * @Version: 1.0.0
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.SpringDemosProject.excel.ExcelConstants;
import com.example.SpringDemosProject.oracle.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

public interface UserMapperForExcel extends BaseMapper<User> {

    @Options(fetchSize = ExcelConstants.USERS_EXPORT_FETCH_SIZE)
    Cursor<User> getAllUsersByCursor();

    List<User> getAllUsersByList();

}
