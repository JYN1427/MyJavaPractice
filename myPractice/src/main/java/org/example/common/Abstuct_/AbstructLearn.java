package org.example.common.Abstuct_;

/*
    抽象方法只有声明没有实现。
    需要注意的是 abstract 关键字只能用于普通方法，不能用于 static 方法或者构造方法中。

    抽象方法的特征如下：
        抽象方法没有方法体
        抽象方法必须存在于抽象类中
        抽象类不能实例化，也就是不能使用 new 关键字创建对象
        子类重写父类时，必须重写父类所有的抽象方法

    注意：
        在使用 abstract 关键字修饰抽象方法时不能使用 private 修饰，
        因为抽象方法必须被子类重写，而如果使用了 private 声明，则子类是无法重写的。
*/

public class AbstructLearn {
    public static void main(String[] args) {
        Square mySquare = new Square(5, 10);
        System.out.println("正方形面积：" + mySquare.area());

        Triangle myTriangle = new Triangle(5, 10);
        System.out.println("三角形面积：" + myTriangle.area());
    }
}
