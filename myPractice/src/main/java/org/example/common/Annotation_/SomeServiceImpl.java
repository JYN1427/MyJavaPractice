package org.example.common.Annotation_;

// 为了配合method反射
public class SomeServiceImpl {
    private Integer num1;
    private Integer nums2;

    public void setArgs(@LengthRange(maxLength = 5) Integer n1, @LengthRange Integer n2) {
        this.num1 = n1;
        this.nums2 = n2;
    }
}
