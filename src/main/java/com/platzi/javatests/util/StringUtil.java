package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times){
        String result = "";

        if(times < 0){
            throw new IllegalArgumentException("Negative times not allowed");
        }

        for (int i = 0;i<times;i++){
            result += str;

        }
        return result;
    }

    public static boolean isEmpty(String str){
        return str == null || str.trim().length() <= 0;
    }


}
