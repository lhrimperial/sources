package com.github.sources.dubbo.base.serialize.kryo;

/**
 * 序列化工具（程序调用该接口来实现obj<->byte[]之间的序列化/反序列化）
 * @author eguid
 *
 */
public interface Serializer{

    /**
     * 序列化
     * @param t
     * @param bytes
     */
    public void serialize(Object t,byte[] bytes);

    /**
     * 序列化
     * @param obj
     * @param bytes
     * @param offset
     * @param count
     */
    public void serialize(Object obj, byte[] bytes, int offset, int count);

    /**
     * 反序列化
     * @param bytes -字节数组
     * @return T<T>
     */
    public <T>T deserialize(byte[] bytes);


    /**
     * 反序列化
     * @param bytes
     * @param offset
     * @param count
     * @return
     */
    public <T>T deserialize(byte[] bytes, int offset, int count);

}