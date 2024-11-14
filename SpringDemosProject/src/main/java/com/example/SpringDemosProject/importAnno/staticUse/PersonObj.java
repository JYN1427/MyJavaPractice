package com.example.SpringDemosProject.importAnno.staticUse;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: Jia Yuning
 * @Description:
 *  测试类, 实现InitializingBean
 * @Date: 2023/08/20 10:31:57
 * @Version: 1.0.0
 */

public class PersonObj implements InitializingBean {

    /**
     * Spring初始化bean的时候,如果bean实现了InitializingBean接口,会自动调用afterPropertiesSet方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() +  "被通过Import创建了");
    }
}
