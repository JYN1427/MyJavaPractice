package com.example.SpringDemosProject.oracle;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/11/21 22:37:26
 * @Version: 1.0.0
 */

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * User实体类
 *
 * @version 1.0
 * @author ss_419
 * @date 2023/8/11 14:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 指定Oracle数据库中的表名
@TableName("jyn.users")
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date created_at;
}
