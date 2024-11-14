package com.example.SpringDemosProject.service;

import com.example.SpringDemosProject.mapper.UserMapper;
import com.example.SpringDemosProject.models.es.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.*;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-09-09 13:15:58
 */
@SpringBootTest
class ESDemoServiceTest {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    @Test
    void add() {
        for (int i = 2; i < 11; i++) {
            User user = new User();
            user.setId(i + "");
            user.setUsername("zhangsan" + i);
            user.setGender("男");
            user.setAge(i + i);
            user.setAddress("河北省" + i);
            //直接将数据保存到es中，索引名称为user-demo，在user对象中设置的
            //通过kibana进行查询GET /user-demo/_search
            User save = userMapper.save(user);
            System.out.println("save = " + save);
        }
    }


    @Test
    void delete() {
        String id = "9";
        userMapper.deleteById(id);
    }

    @Test
    void update() {

        User updateUser = new User();
        updateUser.setId("9");
        updateUser.setUsername("Lisi");
        updateUser.setGender("女");
        updateUser.setAddress("北京市");
        updateUser.setAge(39);

        User save = userMapper.save(updateUser);
        System.out.println("save = " + save);
    }

    @Test
    void find() {
        //模糊查询。精确查询
        Iterable<User> all = userMapper.findAll();
        List<User> list = new ArrayList<>();
        for (User user : all) {
            list.add(user);
        }
        // 使用Collections.sort方法按照用户的ID进行排序
//        Collections.sort(list, Comparator.comparing(User::getId));

        // 使用自定义比较器按照用户的ID进行排序
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                // 假设ID是字符串类型
                return user1.getUsername().compareTo(user2.getUsername());
            }
        });

        // 使用流（Stream）按照用户的ID进行排序
        /*List<User> sortedList = list.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());*/
        // 现在list中的用户已按照ID升序排列
        for (User user : list) {
            System.out.println("user = " + user);
        }

    }

    @Test
    void findById() {
        //注意这里的id是字符串类型，然后userMapper中继承的id也必须是String类型
        Optional<User> byId = userMapper.findById("4");
        System.out.println("byId = " + byId);
    }

    @Test
    void findCount() {
        long count = userMapper.count();
        System.out.println("count 数 " + count);
    }

    @Test
    void existsById() {
        System.out.println("id是否存在： " + userMapper.existsById("1"));
    }

    @Test
    void findByIdAll() {

        ArrayList<String> ids = new ArrayList<>();
        ids.add("3");
        ids.add("5");
        ids.add("4");
        ids.add("66");

        //通过ids（集合）进行查询对应的user集合对象
        Iterable<User> allById = userMapper.findAllById(ids);
        for (User user : allById) {
            System.out.println("user = " + user);
        }
    }


    /**
     * 自定义查询
     */
    @Test
    void findByUsernameLike() {
        //模糊查询，会通过命名规范进行一个查询
        List<User> addr = userMapper.findByAddressLikeIgnoreCaseOrderByAgeDesc("河北");
        System.out.println("addr = " + addr);

        Page<User> page = userMapper.findByUsernameContaining("4", PageRequest.of(0, 100));
        System.out.println("page = " + page.getContent());

        User zhangList = userMapper.findByAge(16);
        System.out.println("user = " + zhangList);

        List<User> gender = userMapper.findByGender("女");
        System.out.println("gender = " + gender);

    }
}