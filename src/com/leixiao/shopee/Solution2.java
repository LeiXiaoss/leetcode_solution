package com.leixiao.shopee;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String str : array) {
            if (map.containsKey(str)) {
                if (map.get(str) >= Integer.valueOf(str)) {
                    continue;
                } else {
                    map.put(str, map.get(str) + 1);
                }
            } else {
                map.put(str, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        int result = 0;
        for (Integer num : list) {
            result += num;
        }
        System.out.println(result);
    }
}
