package org.example.common.Annotation_;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/*
* 使用反射API读取Annotation：
    Class.getAnnotation(Class)
    Field.getAnnotation(Class)
    Method.getAnnotation(Class)
    Constructor.getAnnotation(Class)
    *
    * 通过反射拿注解的思路一定是: 先获取Field/Method...的实例, 然后这个实例调用和
* */
public class AnnotationLearn {
    public static void main(String[] args) {
        // 通过反射进行字段校验
        learnAnnoOfField();

        // 通过反射获取方法入参的注解
        learnAnnoOfParameter();
    }


    public static void learnAnnoOfParameter() {
        Class cls = SomeServiceImpl.class;
        try{
            Method m = cls.getMethod("setArgs", Integer.class, Integer.class); // throws NoSuchMethodException
            Parameter[] parameters = m.getParameters();
            Annotation[][] annotations = m.getParameterAnnotations(); // 第m个参数的第n个注解
            for(int i=0; i< annotations.length; i++) {
                for(int j=0; j < annotations[i].length; j++) {
                    if(annotations[i][j] instanceof LengthRange) {
                        LengthRange lengthRange = (LengthRange) annotations[i][j];
                        System.out.println(parameters[i].getName() + ": min=" + lengthRange.minLength() + ", max=" + lengthRange.maxLength());
                    }else {
                        System.out.println("未知注解");
                        throw new Exception();
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void learnAnnoOfField() {
        Dick myDick = new Dick();
        myDick.setDickName("niu");
        myDick.setDickLength(18);
        // myDick.setDickLength(19);  // IllegalArgumentException
        try {
            checkDick(myDick);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("wrong");
        }
        System.out.println("...");
        System.out.println();
    }

    public static void checkDick(Dick dick) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历该类的所有字段(field), 其中
        for(Field field : dick.getClass().getFields()) {
            // 之所以加这句是因为在目标类中被private修饰的field是私有的, 在别的类中无法被访问
            // 这种暴力反射实际中会用吗？
            field.setAccessible(true);

            // 获取相关注解并判断存在
            LengthRange lengthRange = field.getAnnotation(LengthRange.class);
            if(lengthRange != null) {
                // 获取该field的值, 得到一个Object
                Object fieldValue = field.get(dick);

                // 拿到字段值之后开始校验
                if(fieldValue instanceof Integer) {
                    Integer n = (Integer) fieldValue; // 需要instanceof判断再向下转型
                    if(n < lengthRange.minLength() || n > lengthRange.maxLength()) {
                        throw new IllegalArgumentException(field.getName() + "字段的长度不符合要求");
                    }
                }else if(fieldValue instanceof String){
                    String s = (String) fieldValue; // 需要instanceof判断再向下转型
                    if(s.length() < lengthRange.minLength() || s.length() > lengthRange.maxLength()) {
                        throw new IllegalArgumentException(field.getName() + "字段的长度不符合要求");
                    }
                }else {
                    System.out.println("非长度限制字段, 不予校验");
                }
            }
        }
    }
}


class Dick{
    @LengthRange(minLength = 1, maxLength = 5)
    private String dickName;

    @LengthRange(minLength = 0, maxLength = 18)
    private Integer dickLength;

    public String getDickName() {
        return dickName;
    }

    public void setDickName(String dickName) {
        this.dickName = dickName;
    }

    public int getDickLength() {
        return dickLength;
    }

    public void setDickLength(int dickLength) {
        this.dickLength = dickLength;
    }
}
