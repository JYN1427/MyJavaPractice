package org.example.common.exception_.basic;

public class SimpleTryCatch {
    public static void main(String[] args) {
        tryCatch();

        // zero();

    }

    //
    public static void tryCatch() {
        try{
            Test test = new Test();
            Integer i = Integer.parseInt(test.s);
        } catch (NumberFormatException | NullPointerException e) {
            // 执行相同错误处理逻辑的几种Exception可以用 | 连接
            e.printStackTrace();
        } catch (Exception e) {
            // 父类Exception写在子类下面
            System.out.println(e.getMessage());
        } finally {
            System.out.println("End");
        }
    }

    public static void zero() {
        try{
            int i = 10 / 0;
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}

class Test{
    public String s = "";
}
