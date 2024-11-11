package org.example.common.Interface_.high;

/**
 * 如果接口定义中有且只有一个抽象方法, 可以直接写成lambda表达式
 *
 * @author jiayn01
 * @date 2024-06-11 17:20:17
 */
public class MainTest {
    public static void main(String[] args) {
        // 1 如果接口定义中有且只有一个抽象方法, 可以直接写成lambda表达式
        MyInterface myInterfaceImpl = s -> s + "!";
        doit("Jalen", myInterfaceImpl);

        // 2 也可以用正经方式new一个实现, 在其中Override一下
        MyInterface myInterfaceImpl2 = new MyInterface() {
            @Override
            public String getSth(String name) {
                return name + "!";
            }
        };
        doit("Jalen", myInterfaceImpl2);
    }

    public static void doit(String name, MyInterface myInterface) {
        String sth = myInterface.getSth(name);
        System.out.println(sth);
    }

}
