package com.example.springdemo.allAnnotation.autowired;

import com.example.springdemo.allAnnotation.autowiredAnno.circulation.ServiceA;
import com.example.springdemo.allAnnotation.autowiredAnno.circulation.ServiceB;
import com.example.springdemo.allAnnotation.autowiredAnno.circulation.ServiceC;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/14 21:24:23
 * @Version: 1.0.0
 */
@SpringBootTest
public class AutowiredTest {

    @Autowired
    private ServiceA serviceA;
    @Autowired
    private ServiceB serviceB;
    @Autowired
    private ServiceC serviceC;

    @Test
    public void testCirculation() {
        // ServiceA通过Lazy依赖ServiceB, ServiceC通过Lazy依赖ServiceB,
        // ServiceB直接正常依赖ServiceA和ServiceC

        System.out.println("serviceA.getClass() = " + serviceA.getClass());
        System.out.println("serviceA.getServiceB().getClass() = " + serviceA.getServiceB().getClass());
        System.out.println("serviceB.getServiceA().getClass() = " + serviceB.getServiceA().getClass());

        System.out.println("serviceC.getClass() = " + serviceC.getClass());
        System.out.println("serviceC.getServiceB().getClass() = " + serviceC.getServiceB().getClass());
        System.out.println("serviceB.getServiceC().getClass() = " + serviceB.getServiceC().getClass());
    }
}
