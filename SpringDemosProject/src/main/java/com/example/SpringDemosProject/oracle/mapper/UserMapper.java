package com.example.SpringDemosProject.oracle.mapper;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/11/21 22:37:51
 * @Version: 1.0.0
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.SpringDemosProject.oracle.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    // 这里可以自定义一些数据库操作方法

    /**
     * 测试Mapper.xml
     *
     * @return
     */
    User selectOneUser(@Param("userId") String userId);



}
