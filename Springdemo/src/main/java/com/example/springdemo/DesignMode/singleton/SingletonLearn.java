package com.example.springdemo.DesignMode.singleton;

/**
 * 单例模式的普通练习
 *      饿汉式 - 静态常量           (线程安全)
 *      懒汉式 - 普通方法           (线程不安全)
 *      懒汉式 - 普syn同步方法      (线程安全)
 */
public class SingletonLearn {
    // 单例模式举例:
    //    1. windows的Task Manager(任务管理器) 和 Recyle Bin(回收站)
    //    2. 应用程序的日志
    //    3. 数据库的连接池
}


// 饿汉式: 立即加载, 占用内存时间长, 但线程安全
class Bank{
    // 中国人民银行
    // 1. 构造器私有化
    private Bank() {
    }

    // 2. 静态的Bank对象成员
    private static Bank bank = new Bank();

    // 3. 公有的获取对象实例的get方法(同样也是static的)
    public static Bank getBankInstance(){
        return bank;
    }
}


// 普通懒汉式: 延迟加载, 占用内存时间短, 线程不安全 可能会new多次
class GirlFriend{
    // 女朋友
    private GirlFriend() {
    }

    private static GirlFriend girlFriend = null;

    public static GirlFriend getGirlFriend() {
        if(girlFriend == null) {
            girlFriend = new GirlFriend();
        }
        return girlFriend;
    }

}


/**
 * 懒汉式 - 普syn同步方法      (线程安全)
 */
class BoyFriend{
    private BoyFriend() {
    }

    private static BoyFriend girlFriend = null;

    public static synchronized BoyFriend getGirlFriend() {
        if(girlFriend == null) {
            girlFriend = new BoyFriend();
        }
        return girlFriend;
    }

}


class Single{
    private Single() {}
    private static Single s = new Single();
    public static Single getInstance(){return s;}
}