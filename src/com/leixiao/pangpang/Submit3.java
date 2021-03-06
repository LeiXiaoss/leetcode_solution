package com.leixiao.pangpang;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Submit3 {
    public static String reMoveDuplicates(String sStr, int iStrLen, int iNumber) {
        if (sStr == null || sStr.length() == 0) {
            return "";
        }

        List<String> strList = new ArrayList(Arrays.asList(sStr.split("")));

        boolean change = true;

        while (change) {
            for (int i=0;i<iStrLen;) {
                char start = sStr.charAt(i);
                
            }
        }



        return "";
    }

    public static void main(String[] args) {
        reMoveDuplicates("aabbbeccceeffaccfcaa", 20, 3);
    }
}
