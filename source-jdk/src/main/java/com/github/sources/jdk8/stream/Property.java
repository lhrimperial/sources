package com.github.sources.jdk8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Property {
    private String name;
    private Integer distance;
    private Integer sales;
    private Integer priceLevel;

    public Property(String name, Integer distance, Integer sales, Integer priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }

    public static void main(String[] args) {
        Property p1 = new Property("叫了个鸡", 1000, 500, 2);
        Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
        Property p3 = new Property("永和大王", 580, 3000, 1);
        Property p4 = new Property("肯德基", 6000, 200, 4);
        List<Property> properties = Arrays.asList(p1, p2, p3, p4);
//        Collections.sort(properties, (x, y) -> x.distance.compareTo(y.distance));
//        String name = properties.get(0).name;
//        System.out.println("距离我最近的店铺是:" + name);

        // Stream操作
        String name2 = properties.stream()
                .sorted(Comparator.comparingInt(x -> x.distance))
                .findFirst()
                .get().name;
        System.out.println("距离我最近的店铺是:" + name2);
    }
}
