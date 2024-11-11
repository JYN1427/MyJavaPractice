package com.example.springdemo.DesignMode.template.learn;

public class TemplateLearn {
    public static void main(String[] args) {
        Template p = new PrintPrimeNumber();
        p.printUseTime();
    }
}


abstract class Template{
    public Integer num;
    // 模板方法
    public void printUseTime() {
        double start = System.currentTimeMillis();

        code();

        double end = System.currentTimeMillis();

        System.out.println("花费时间: " + (end - start));
    }

    public abstract void code();
}


class PrintPrimeNumber extends Template{

    @Override
    public void code() {
        // 随便写一个打印质数的功能
        for(int i=2; i < 1000; i++){
            boolean isFlag = false;
            for(int j=2; j < Math.abs(i) ; j++){
                if(i % j == 0){
                    isFlag = true;
                    break;
                }
            }
            if(!isFlag) {
                System.out.println(i);
            }
        }
    }
}
