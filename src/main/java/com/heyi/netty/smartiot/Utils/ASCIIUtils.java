package com.heyi.netty.smartiot.Utils;


public class ASCIIUtils {


    /**
     * ASCII --> String
     *
     * @param value
     * @return
     */
    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split("/");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) (Integer.parseInt(chars[i]) - 1));
        }
        return sbu.toString();
    }

    /**
     * 字符串转换为Ascii
     *
     * @param value
     * @return
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i] + 1).append("/");
            } else {
                sbu.append((int) chars[i] + 1);
            }
        }
        return sbu.toString();
    }

}
