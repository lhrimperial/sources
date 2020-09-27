package com.github.sources.dubbo.base.serialize.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

/**
 *
 */
public class ProtoBufTest {

    public static void main(String[] args){
        System.out.println("===== 构建一个GPS模型开始 =====");
        BatteryData.gps_data.Builder gps_builder = BatteryData.gps_data.newBuilder();
        gps_builder.setAltitude(1);
        gps_builder.setDataTime("2017-12-17 16:21:44");
        gps_builder.setGpsStatus(1);
        gps_builder.setLat(39.123);
        gps_builder.setLon(120.112);
        gps_builder.setDirection(30.2F);
        gps_builder.setId(100L);

        BatteryData.gps_data gps_data = gps_builder.build();
        System.out.println(gps_data.toString());
        System.out.println("===== 构建GPS模型结束 =====");

        System.out.println("===== gps Byte 开始=====");
        for(byte b : gps_data.toByteArray()){
            System.out.print(b);
        }
        System.out.println("\n" + "bytes长度" + gps_data.toByteString().size());
        System.out.println("===== gps Byte 结束 =====");

        System.out.println("===== 使用gps 反序列化生成对象开始 =====");
        BatteryData.gps_data gd = null;
        try {
            gd = BatteryData.gps_data.parseFrom(gps_data.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.print(gd.toString());
        System.out.println("===== 使用gps 反序列化生成对象结束 =====");

        System.out.println("===== 使用gps 转成json对象开始 =====");

        String jsonFormatM = "";
        try {
            jsonFormatM = JsonFormat.printer().print(gd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(jsonFormatM.toString());
        System.out.println("json数据大小：" + jsonFormatM.getBytes().length);
        System.out.println("===== 使用gps 转成json对象结束 =====");
    }
}
