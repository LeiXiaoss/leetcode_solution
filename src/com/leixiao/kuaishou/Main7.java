package com.leixiao.kuaishou;

import java.util.*;

public class Main7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String digits = in.nextLine();

        List<String> list = letterCombinations(digits);

        System.out.print("[");
        for (int i=0;i<list.size();i++) {
            if (i == list.size()-1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i)+", ");
            }
        }
        System.out.print("]");

    }
    public static List<String> letterCombinations(String digits) {
        List<String> strList = new ArrayList<>();

        if(digits == null || digits.length() == 0) return strList;

        String[] map  = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        letterCombinationsCore(strList,digits,map,"");
        return strList;
    }

    public static void letterCombinationsCore(List<String> list,String digits,String[] map,String ans){
        if(digits.length() == ans.length()){
            list.add(ans);
            return;
        }

        for (char ch : map[digits.charAt(ans.length())-'2'].toCharArray()){
            letterCombinationsCore(list,digits,map,ans+ch);
        }
    }

    //根据队列不断拼接结果
    public List<String> letterCombinations1(String digits){
        List<String> strList = new LinkedList<String>();
        if(digits.isEmpty()) return Collections.emptyList();

        String[] map  = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] charArray = digits.toCharArray();
        strList.add("");

        for (int i=0;i<charArray.length;i++){
            char ch = charArray[i];
            while (((LinkedList<String>) strList).getFirst().length()==i){
                String pop = ((LinkedList<String>) strList).removeFirst();
                for (char c : map[ch-'2'].toCharArray()){
                    strList.add(pop+c);
                }
            }
        }
        return strList;
    }
}
