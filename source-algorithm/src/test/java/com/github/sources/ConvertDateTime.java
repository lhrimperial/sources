package com.github.sources;

import java.text.SimpleDateFormat;

/**
 *
 */
public class ConvertDateTime {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception{
        System.out.println(sdf.parse("2018-10-29 00:00:00").getTime());
        System.out.println(sdf.parse("2018-10-29 23:59:59").getTime());
        //
    }
}
