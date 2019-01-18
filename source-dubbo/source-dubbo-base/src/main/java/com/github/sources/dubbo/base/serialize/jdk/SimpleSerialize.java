package com.github.sources.dubbo.base.serialize.jdk;

import java.io.*;

/**
 *
 */
public class SimpleSerialize {

    public static void main(String[] args) throws Exception{
        //序列化
        FileOutputStream fos = new FileOutputStream("source-dubbo\\source-dubbo-base\\object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        User user = new User("andy", "123", "male");
        Person person = new Person("andy", "123", "male");
        user.setPerson(person);
        oos.writeObject(user);
        oos.flush();
        oos.close();

        //反序列化
        FileInputStream fis = new FileInputStream("source-dubbo\\source-dubbo-base\\object.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user2 = (User) ois.readObject();
        System.out.println(user2);
        System.out.println(user2.getPerson());
    }


    //必须实现Serializable，否则序列化异常NotSerializableException
    public static class Person {
        private String userName;
        private String password;
        private String sex;
        public Person() {
        }

        public Person(String userName, String password, String sex) {
            this.userName = userName;
            this.password = password;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }

    }

    public static class User implements Serializable {
        private String userName;
        private String password;
        private String sex;

        private Person person;

        public User() {
        }

        public User(String userName, String password, String sex) {
            this.userName = userName;
            this.password = password;
            this.sex = sex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}


