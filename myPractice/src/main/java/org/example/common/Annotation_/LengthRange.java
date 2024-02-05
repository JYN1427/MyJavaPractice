package org.example.common.Annotation_;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 作用于类的field: 字段取值长度范围要求
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthRange {
    int minLength() default 0; // 最小长度
    int maxLength() default 20; // 最大长度
}
