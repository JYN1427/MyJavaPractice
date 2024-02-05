package org.example.common.Enumerate_;

public class EnumerateLearn {
    public static void main(String[] args) {
        /*
            values()	以数组形式返回枚举类型的所有成员
            valueOf()	将普通字符串转换为枚举实例
            compareTo()	比较两个枚举成员在定义时的顺序
            ordinal()	获取枚举成员的索引位置
        */
        myCompare(Sex.valueOf("other"));

        myTest4Imp();
    }

    public static void myCompare(Sex s){
        Sex[] myEnumList = s.values();
        for(int i=0; i < myEnumList.length; i++) {
            // 比较s和myEnumList[i]在Sex中的 相对距离
            System.out.println(s + "与" + myEnumList[i] + "的比较结果是：" + s.compareTo(Sex.values()[i]));
        }
    }

    public static void myTest4Imp() {
        Sex.male.printGender();
        Sex.female.printGender();

        Sex.male.sayHi();
        Sex.female.sayHi();
    }
}
