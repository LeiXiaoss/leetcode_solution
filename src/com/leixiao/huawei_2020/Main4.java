package com.leixiao.huawei_2020;

public class Main4 {
    public String getLongSameStr(String s1, String s2) {
        String min,max;

        if (s1.length() > s2.length()) {
            max = s1;
            min = s2;
        } else {
            max = s2;
            min = s1;
        }

        if (max.contains(min)) {
            return min;
        }

        for (int i = 0 ; i < min.length() ; i++) {
            for (int start = 0, end = min.length() - i ; end <= min.length() ; start++, end++) {
                String temp = min.substring(start, end);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Main4().getLongSameStr("abcd","cdefadc"));
    }
}
