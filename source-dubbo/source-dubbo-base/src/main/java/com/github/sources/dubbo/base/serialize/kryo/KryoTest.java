package com.github.sources.dubbo.base.serialize.kryo;

import java.util.Arrays;

/**
 *
 */
public class KryoTest {

    public static void main(String[] args){
        Serializer ser = new kryoSerializer(Person.class);
        for (int i = 0; i < 10; i++) {

            Person msg = new Person(12,"andy","123456");

            byte[] bytes = new byte[1024];
            long start = System.nanoTime();
            ser.serialize(msg, bytes);
            System.err.println("序列化耗时：" + (System.nanoTime() - start));
            System.out.println("压缩："+bytes.length);
            System.out.println(msg);
            System.out.println(Arrays.toString(bytes));

            Person newmsg = null;
            start = System.nanoTime();
            newmsg = ser.deserialize(bytes);
            System.err.println("反序列化耗时：" + (System.nanoTime() - start));
            System.out.println(newmsg);
        }
    }

    static class Person{
        private Integer id;
        private String name;
        private String password;

        public Person() {
        }

        public Person(Integer id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
