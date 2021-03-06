package com.leixiao.pangpang;

import java.util.HashMap;
import java.util.Map;

public class Submit {
    public static String luckClient(String clients, int target) {
        Map<Integer, String> customMap = new HashMap<>();

        String[] customs = clients.split(",");
        for (String custom : customs) {
            String[] temp = custom.split(":");
            int point = Integer.parseInt(temp[1]);

            if (customMap.containsKey(point)) {
                customMap.put(point, customMap.get(point)+","+temp[0]);
            } else {
                customMap.put(point, temp[0]);
            }
        }

        String result;
        if (customMap.containsKey(target)) {
            result = customMap.get(target);
        } else {
            result = "NONE";
        }

        return result;
    }
}
