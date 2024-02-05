package org.example.common.exception_.highLevel;


public class AboutTransactional {

    /**
     * 把子方法看成是被@Transactional修饰的方法；
     * 把main方法看成是AOP之后的代理对象的方法。
     *
     * 也就是无论你在被@Transactional修饰的方法是body throw还是method throws, 事务都能正常回滚。
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            justThrow(0);
        } catch (Exception e) {
            System.out.println("error found 1");
        }

        try {
            throwAndThrows(0);
        } catch (Exception e) {
            System.out.println("error found 2");
        }
    }

    /**
     * 方法体主动抛出异常
     *
     * @param num
     */
    public static void justThrow(Integer num){
        if (num > 0) {
            System.out.println("ok");
        } else {
            throw new RuntimeException("num只能大于0");
            // throw new Exception("num只能大于0");是不行的
            // 运行时异常可以throw. 但不能是编译时异常, 因为编译时异常必须解决(要么catch要么throws).
        }
    }

    /**
     * 方法throws异常
     *
     * @param num
     * @throws Exception
     */
    public static void throwAndThrows(Integer num) throws Exception {
        int x = 1 / num;
    }
}
