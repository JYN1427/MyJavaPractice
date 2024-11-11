package com.example.springdemo.copyProperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/05 21:19:51
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CopyPropertiesLearn {
    @Autowired
    private SourceBean sourceBean;
    @Autowired
    private TargetBean targetBean;

    /*
    * 有这样几个地方需要注意:
    * 0. copyProperties()操作的Bean一定要有get和set方法! 因为copyProperties()是基于反射实现的
    *   (所以反射也造成copyProperties()的效率比较低, 其实比setter低得多)
    * 1. BeanUtils.copyProperties() 是浅拷贝
    * 2. Bean的属性最好是包装类
    * 3. 如果想通过查Bean的set方法的usages来看哪些地方对该字段进行了修改, 是不全面的, 因为usages不会展示copyProperties的地方
    * */

    @Test
    public void test() {
        sourceBean.setName("source");
        sourceBean.setValue(1);
        sourceBean.setGood(true);

        targetBean.setName("target");
        targetBean.setValue(999);


        BeanUtils.copyProperties(sourceBean, targetBean);
        System.out.println(targetBean.getName());
        System.out.println(targetBean.getValue());
        System.out.println(targetBean.getGood());
    }

}
