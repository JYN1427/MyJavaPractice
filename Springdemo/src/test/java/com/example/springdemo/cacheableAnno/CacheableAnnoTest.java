package com.example.springdemo.cacheableAnno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.util.StopWatch;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/21 21:23:26
 * @Version: 1.0.0
 */

// 别忘了EnableCaching
@EnableCaching
@SpringBootTest
public class CacheableAnnoTest {
    @Autowired
    CacheableAnnoLearn cacheableAnnoLearn;

    @Test
    public void test1() {
        StopWatch stopWatch = new StopWatch();
        // 第一次
        stopWatch.start("No.0");
        Model model0 = cacheableAnnoLearn.getModelById(1);
        stopWatch.stop();

        // 第一次getModelByModel
        // 但他和getModelById都属于“byId”组里的, 一旦两个方法设置的key也相同, 那每当相同的参数传进来那getModelByModel就能复用答案
        stopWatch.start("No.1");
        Model model1 = cacheableAnnoLearn.getModelById(new QueryParam().setId(1));
        stopWatch.stop();

        // 第二次getModelByModel
        stopWatch.start("No.2");
        Model model2 = cacheableAnnoLearn.getModelById(new QueryParam().setId(1));
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }


    /**
     * 用于把执行结果更新缓存数据
     * 相当于"双写模式", 顺序是先写入数据库,
     */
    @Test
    public void testCachePut() {

    }
}
