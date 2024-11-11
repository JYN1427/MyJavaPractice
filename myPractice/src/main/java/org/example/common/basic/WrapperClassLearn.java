package org.example.common.basic;

public class WrapperClassLearn {
    public static void main(String[] args) {
        // 1 装箱
        int num = 10;
        Integer myNum = Integer.valueOf(num);

        float f = 1.23F;
        Float myF = Float.valueOf(f);


        // 2 拆箱
        int x = myNum.intValue();
        float y = myF.floatValue();


        // 3 注意：基本数据类型的默认值 和 包装类的默认值不同
        Test myTest = new Test();
        System.out.println(myTest.isFlag); // false
        System.out.println(myTest.myIsFlag); // null


        // 4 String的互转
        // 基本类型/包装类 ----> String
        String s1 = String.valueOf(num);
        String s2 = "" + num;

        // String ----> 基本类型/包装类
        String str = "123";
        int i = Integer.parseInt(str);
        Double d = Double.parseDouble(str);

        try{
            String ss = "123a";
            Integer WrongInt = Integer.parseInt(ss);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}

class Test{
    public boolean isFlag;
    public Boolean myIsFlag;
}
