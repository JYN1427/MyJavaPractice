package com.example.SpringDemosProject.oracle.service;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/11/21 22:40:19
 * @Version: 1.0.0
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringDemosProject.oracle.User;
import com.example.SpringDemosProject.oracle.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ss_419
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    public User getUser(String userId) {
        User user = userMapper.selectOneUser(userId);
        return user;
    }

    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    public void saveUser(User user) {
        userMapper.insert(user);
    }

    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }
}

