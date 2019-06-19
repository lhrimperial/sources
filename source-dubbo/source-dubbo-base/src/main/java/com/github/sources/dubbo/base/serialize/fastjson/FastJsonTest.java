package com.github.sources.dubbo.base.serialize.fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeWriter;

/**
 *
 */
public class FastJsonTest {

    public static void main(String[] args){
        User user = new User("andy",28);
        System.out.println(JSON.toJSONString(user));
        SerializeWriter serializeWriter = new SerializeWriter();
    }

    static class User{
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
