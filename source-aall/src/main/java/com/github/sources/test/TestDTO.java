package com.github.sources.test;

import java.io.Serializable;

public class TestDTO implements Serializable {

    private static final long serialVersionUID = -396444235213802360L;

    private String nanme;
    private int age;
    private String password;

    public String getNanme() {
        return nanme;
    }

    public void setNanme(String nanme) {
        this.nanme = nanme;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
