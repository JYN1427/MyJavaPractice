package org.example.common.exception_;

// 逻辑中主动抛异常
public class ActiveThrowException {
    public static void main(String[] args) {

    }

    public static void test(Integer num){
        if (num > 0) {
            System.out.println("ok");
        } else {
            throw new RuntimeException("num只能大于0");
            // throw new Exception("num只能大于0");是不行的
            // 运行时异常可以throw. 但不能是编译时异常, 因为编译时异常必须解决(要么catch要么throws).
        }
    }
}
