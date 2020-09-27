package com.github.sources.dubbo.base.serialize.jdk;

import java.awt.print.Book;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class PartSerialize {

    public static void main(String[] args) throws Exception{
//        testTransient();
//        testOverride();
        testExternalizable();
    }

    public static void testExternalizable() throws Exception{
        Book3 book = new  Book3("Hello Java");
        book.setIsbn("ABC123456789");
//        book.setName("Hello Java");
        book.setAuthors(Arrays.asList("John","Eric"));
        System.out.println("book==>" + book);

        /**
         * 将book对象序列化到book.temp文件中去
         */
        String fileName = Constants.dir+"book.temp";
        SerializationUtil.serialize(book, fileName);

        /**
         * 从book.temp文件中，反序列化一个Book对象
         */
        Book3 deserializedBook = (Book3) SerializationUtil.deserialize(fileName);
        //deserializedBook==>Book [name=Hello Java, isbn=ABC123456789, authors=[John, Eric]]
        System.out.println("deserializedBook==>" + deserializedBook);
    }

    public static void testOverride() throws Exception{
        Book2 book = new  Book2("Hello Java");
        book.setIsbn("ABC123456789");
//        book.setName("Hello Java");
        book.setAuthors(Arrays.asList("John","Eric"));
        System.out.println("book==>" + book);

        /**
         * 将book对象序列化到book.temp文件中去
         */
        String fileName = Constants.dir+"book.temp";
        SerializationUtil.serialize(book, fileName);

        /**
         * 从book.temp文件中，反序列化一个Book对象
         */
        Book2 deserializedBook = (Book2) SerializationUtil.deserialize(fileName);
        //deserializedBook==>Book [name=Hello Java, isbn=ABC123456789, authors=[John, Eric]]
        System.out.println("deserializedBook==>" + deserializedBook);
    }

    public static void testTransient() throws Exception{
        Book1 book = new  Book1();
        book.setIsbn("ABC123456789");
        book.setName("Hello Java");
        book.setAuthors(Arrays.asList("John","Eric"));
        System.out.println("book==>" + book);

        /**
         * 将book对象序列化到book.temp文件中去
         */
        String fileName = Constants.dir+"book.temp";
        SerializationUtil.serialize(book, fileName);

        /**
         * 从book.temp文件中，反序列化一个Book对象
         */
        Book1 deserializedBook = (Book1) SerializationUtil.deserialize(fileName);
        //deserializedBook==>Book [name=Hello Java, isbn=ABC123456789, authors=[John, Eric]]
        System.out.println("deserializedBook==>" + deserializedBook);
    }

    public static class Book3 implements Externalizable {
        /**书名*/
        private String name;

        /**ISBN*/
        private String isbn;

        /**作者*/
        private List<String> authors;

        public Book3(String name) {
            this.name = name;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
            out.writeObject(isbn);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
            isbn = (String) in.readObject();
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        @Override
        public String toString() {
            return "Book2{" +
                    "name='" + name + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", authors=" + authors +
                    '}';
        }
    }

    public static class Book2 implements Serializable{
        /**书名*/
        private String name;

        /**ISBN*/
        private String isbn;

        /**作者*/
        private List<String> authors;

        public Book2(String name) {
            this.name = name;
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            // oos.defaultWriteObject();
            oos.writeObject(name);
            oos.writeObject(isbn);
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            // ois.defaultReadObject();
            name = (String) ois.readObject();
            isbn = (String) ois.readObject();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        @Override
        public String toString() {
            return "Book2{" +
                    "name='" + name + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", authors=" + authors +
                    '}';
        }
    }

    public static class Book1 implements Serializable{
        /**书名*/
        private String name;

        /**ISBN*/
        private transient String isbn;

        /**作者*/
        private transient List<String> authors;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        @Override
        public String toString() {
            return "Book1{" +
                    "name='" + name + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", authors=" + authors +
                    '}';
        }
    }

}
