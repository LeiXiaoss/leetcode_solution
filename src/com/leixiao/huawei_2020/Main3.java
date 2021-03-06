package com.leixiao.huawei_2020;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String start = in.nextLine();
        int groupCount = Integer.parseInt(in.nextLine());
        List<List<String>> groupList = new ArrayList<>(groupCount);
        Set<String> receiver = new HashSet<>();
        receiver.add(start);

        while (groupCount > 0) {
            groupList.add(Arrays.asList(in.nextLine().split(",")));
            groupCount--;
        }

        if (groupList.size() <= 0 ) {
            System.out.println(groupList.size());
            return;
        }

        int before = groupList.size()+1;
        int after = groupList.size();
        while (before > after && after>0) {
            before = after;
            for (List<String> group : groupList) {
                for (String name : group) {
                    if (receiver.contains(name)) {
                        receiver.addAll(group);
                        after--;
                        break;
                    }
                }
            }
        }

        System.out.println(receiver.size());
    }
}
