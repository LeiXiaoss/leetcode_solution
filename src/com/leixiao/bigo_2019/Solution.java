package com.leixiao.bigo_2019;

import com.leixiao.forjob.ArrayStack;
import com.leixiao.leetcode.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean isListPalindrom(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();

        int count = 0;
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            count++;
            current = current.next;
        }

        for (int i=1,j=count;i<j;i++,j--) {
            if (nodes.get(i) != nodes.get(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isNewVersion(String v1, String v2) {
        String[] v1Array = v1.split(".");
        String[] v2Arrar = v2.split(".");

        for (int i=0,j=0 ; i<v1Array.length&&j<v2Arrar.length ; i++,j++) {
            if (Integer.parseInt(v1Array[i]) < Integer.parseInt(v2Arrar[j])) {
                return true;
            } else if (Integer.parseInt(v1Array[i]) > Integer.parseInt(v2Arrar[j])) {
                return false;
            }
        }

        if (v1Array.length >= v2Arrar.length) {
            return false;
        }
        return true;
    }

    public boolean isAllInDict(String s, String[] wordDict) {
        List<String> dict = Arrays.asList(wordDict);

        int i=0,j=1;
        for (; i<j&&j<s.length() ; ) {
            String temp = s.substring(i,j);

            if (dict.contains(temp)) {
                i=j+1;
                j=j+2;
            }else {
                j++;
            }
        }

        if (i < wordDict.length-1) {
            return false;
        }
        return true;
    }
}
