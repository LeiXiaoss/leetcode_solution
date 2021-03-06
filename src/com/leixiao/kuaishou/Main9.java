package com.leixiao.kuaishou;

import java.util.Scanner;

public class Main9 {
    public static String ipValid(String ip) {
        if (ip.trim().equals(""))return "Neither";

        int length = ip.length();
        if (ip.substring(length-1).equals(":")||
                ip.substring(length-1).equals(".")){

            return "Neither";
        }

        String[] v4 = ip.split("\\.");
        String[] v6 = ip.split("\\:");

        if (v4.length == 4 && v6.length != 8) {

            for (String s : v4) {
                if (s.length() > 3 || s.length() == 0) {
                    return "Neither";
                }

                char[] chars = s.toCharArray();

                if (chars.length > 1 && chars[0] == '0') return "Neither";
                for (char c : chars) {
                    if (c - '0' < 0 || '9' - c < 0) {
                        return "Neither";
                    }
                }

                int change = Integer.parseInt(s);
                if (change < 0 || change > 255) return "Neither";
            }
            return "IPv4";
        } else if (v4.length != 4 && v6.length == 8) {
            for (int i=0;i< v6.length;i++) {

                if (v6[i].length() > 4 || v6[i].length()==0) {
                    return "Neither";
                }

                char[] chars = v6[i].toCharArray();
                for (int k=0;k< chars.length;k++) {
                    if ((chars[k] - '0' >=0 && '9' - chars[k] >= 0) || (chars[k] >='a' &&
                            chars[k] <= 'f' )|| (chars[k] >= 'A' && chars[k] <= 'F')){
                        continue;
                    }else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        System.out.println(ipValid(ip));
    }
}
