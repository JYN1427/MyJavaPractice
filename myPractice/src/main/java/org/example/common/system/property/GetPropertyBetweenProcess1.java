package org.example.common.system.property;

/**
 * 设置指定键对值的系统属性
 * setProperty (String prop, String value);
 *
 * 抛出：
 * SecurityException - 如果安全管理器存在并且其 checkPermission 方法不允许设置指定属性。
 * NullPointerException - 如果 key 或 value 为 null。
 * IllegalArgumentException - 如果 key 为空。
 * 注：这里的system，系统指的是 JRE (runtime)system，不是指 OS。
 *
 * System.setProperty 相当于一个静态变量 ，存在内存里面
 *
 * @author jiayn01
 * @date 2023-10-20 10:31:52
 */
public class GetPropertyBetweenProcess1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("kk", "vv");
        Thread.sleep(30000);
    }
}
