package com.leixiao.newleetcode._841;

import java.util.*;

public class Solution {
    Set<Integer> allKeys = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        getKey(rooms, 0);
        return allKeys.size() == rooms.size();
    }

    private void getKey(List<List<Integer>> rooms, int r) {
        List<Integer> room = rooms.get(r);
        allKeys.add(r);

        for (int key : room) {
            if (!allKeys.contains(key)) {
                getKey(rooms, key);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List rooms = new ArrayList();
        List<Integer> room1 = Arrays.asList(1,3);
        List<Integer> room2 = Arrays.asList(3,0,1);
        List<Integer> room3 = Arrays.asList(2);
        List<Integer> room4 = Arrays.asList(0);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        System.out.println(solution.canVisitAllRooms(rooms));
    }
}
