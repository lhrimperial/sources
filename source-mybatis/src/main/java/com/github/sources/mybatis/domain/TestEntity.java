package com.github.sources.mybatis.domain;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 */
public class TestEntity {
    private long id;
    private String name;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
    public static void main(String[] args){
       add(null,"a");
    }

    public static BigDecimal add(BigDecimal a, String b) {
        if (Objects.isNull(a)) {
            a = BigDecimal.ZERO;
        }
        if (StringUtils.isEmpty(b)) {
            return a;
        }
        return a.add(new BigDecimal(b.trim()));
    }
}
