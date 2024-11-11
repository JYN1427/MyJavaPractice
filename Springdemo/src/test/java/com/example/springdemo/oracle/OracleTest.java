package com.example.springdemo.oracle;

import com.example.springdemo.oracle.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/11/21 22:39:45
 * @Version: 1.0.0
 */
@SpringBootTest
public class OracleTest {
    @Autowired
    private UserService service;

    @Test
    public void testXML() {
        User user = service.getUser("1");
        System.out.println(user);
    }

    /**
     * 获取所有用户信息
     */
    @Test
    public void testGetAllUsers() {
        List<User> users = service.getAllUsers();
        users.forEach(System.out::println);
    }

    /**
     * 根据id获取用户
     */
    @Test
    public void testGetUserById() {
        User userById = service.getUserById(1L);
        System.out.println("userById = " + userById);
    }

    /**
     * 保存用户
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setId(1000L);
        user.setUsername("测试新增User");
        user.setPassword("00101010");
        user.setEmail("test@example.com");
        user.setCreated_at(new Date());
        service.saveUser(user);
    }

    /**
     * 更新用户
     */
    @Test
    public void testUpdateUser() {
        // 先查询
        User user = service.getUserById(1000L);
        System.out.println("userById = " + user);
        // 后更新
        user.setUsername("update_username");
        service.updateUser(user);
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void testDeleteUser() {
        service.deleteUser(1000L);
    }
}
