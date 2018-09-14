package com.github.sources.proxy.loader;

/**
 *
 */
public class MyClassLoader<T> extends ClassLoader {

    /**
     * 自定义一个类加载器，用于将字节码转换为class对象
     * @param name   The expected binary name of the class, or null if not known
     * @param bs
     * @param off
     * @param len
     * @return
     */
    @SuppressWarnings("unchecked")
    public Class<T> defineMyClass(String name, byte[] bs, int off, int len) {
        return (Class<T>) super.defineClass(name, bs, off, len);
    }
}
