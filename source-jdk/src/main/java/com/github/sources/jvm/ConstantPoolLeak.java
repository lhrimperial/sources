package com.github.sources.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 编译期的数字常量、方法或者域的引用（在运行时解析）
 * Exception in thread "main"java.lang.OutOfMemoryError: PermGen space
 */
public class ConstantPoolLeak {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(UUID.randomUUID().toString().intern());
        }
    }
}
