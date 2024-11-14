//package org.example.maven.optional;
//
//import org.example.optional.Father;
//
///**
// * 前情提要:
// *      ProjectB
// *          1.0-Snapshot、2.0-Snapshot实现方式不同, 打印字符串不同的
// *      ProjectA
// *          1.0-Snapshot正常引用了ProjectB 1.0-Snapshot
// *          2.0-Snapshot通过optional标签为true 引用了ProjectB 1.0-Snapshot
// *      A中的方法对B进行了调用
// *
// * 情况1:
// *      本项目引用ProjectA 1.0-Snapshot (ProjectA 1.0-Snapshot引用ProjectB 1.0-Snapshot)
// *      此时本项目调用ProjectA中的所写方法, pom中不需要引用ProjectB即可正常编译,
// *      可以正常调用 Method -> projectA -> projectB
// *
// *  情况2:
// *      本项目引用ProjectA 2.0-Snapshot (optional标签为true引用ProjectB 1.0-Snapshot)
// *      此时本项目调用ProjectA中的所写方法, 报错找不到目标类
// *      无法正常调用 Method -> projectA -x-> projectB
// *
// *      需要在本项目pom中引用ProjectB:
// *          (1) 本项目引用projectB 1.0-Snapshot, 则实现:
// *              Method -> projectA 2.0 -> projectB 1.0
// *          (2) 本项目引用projectB 2.0-Snapshot, 则实现:
// *          Method -> projectA 2.0 -> projectB 2.0
// *
// *      故而, ProjectA通过将对Project的依赖设置为optional=true, 实现了对ProjectB的解耦
// *      这样引用ProjectA的项目就可以自由的选择ProjectB的版本
// */
//public class Maintest {
//    public static void main(String[] args) {
//        Father father = new Father();
//        father.getDtr();
//    }
//
//}
