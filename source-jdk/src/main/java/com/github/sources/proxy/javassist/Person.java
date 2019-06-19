package com.github.sources.proxy.javassist;

/**
 *
 */
public class Person implements Smileable, Talkable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Object talk(String words) throws Exception {
        System.out.println(name + " says: " + words);
        return words;
    }

    public Object smile() throws Exception {
        System.out.println(name + " start smiling");
        System.out.println(name + " stop smiling");
        return null;
    }

}
