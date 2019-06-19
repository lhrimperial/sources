package com.github.sources.loader;

/**
 * 类加载过程：加载、验证、准备、解析、初始化、使用、卸载
 *
 */
public class InitClassTest {

    public static void main(String[] args){
        /**
         * 对于静态属性，只有定义这个字段的类才会被初始化，因此通过子类引用父类的静态属性
         * 只会触发父类初始化，而不会触发子类初始化
         */
        System.out.println(SubClass.value);

//        System.out.println(SubClass.a);
    }
}
