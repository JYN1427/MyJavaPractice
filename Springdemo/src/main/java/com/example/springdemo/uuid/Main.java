package com.example.springdemo.uuid;


/**
 * 实践
 *
 * @author jiayn01
 * @date 2023-11-09 14:13:52
 */
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 在拦截器中可以给Request和Response中插入序列id, 方便定位问题
     */
    public static void test1() {
        long t1 = System.currentTimeMillis();
        String reqSeq = UUIDUtil.generateReqSeq(t1);

        System.out.println(reqSeq);

//        HttpServletRequest httpRequest =
//                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        httpRequest.setAttribute('reqSeq', reqSeq);
    }

    /**
     * 生成32位数据库uuid主键
     */
    public static void test2() {
        String s = UUIDUtil.getNewGuid();
        System.out.println(s);
        System.out.println(s.length());

    }

}