package org.example.common.Enumerate_;

// 枚举类就是包含固定种对象的一种模板
// 枚举类可以去实现接口
public enum Sex implements Action4Enum{
    male(1, "男"){
        public void printGender() {
            // 在具体枚举对象的定义中重写接口中的抽象方法。当通过不同的枚举类对象调用此方法时,执行的是不同的方法。
            System.out.println("I am " + this.getDesc());
        }
    },
    female(2, "女"){
        public void printGender() {
            System.out.println("I am " + this.getDesc());
        }
    },
    other(3, "其它"){
        public void printGender() {
            System.out.println("I am " + this.getDesc());
        }
    };

    private int value;
    private String desc;


    // 构造方法
    private Sex(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    @Override
    public void sayHi() {
        // 枚举类实现接口,在枚举类中重写接口中的抽象方法。当通过不同的枚举类对象调用此方法时,执行的是同一个方法。
        System.out.println("Hi");
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
