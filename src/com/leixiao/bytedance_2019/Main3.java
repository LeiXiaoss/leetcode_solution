package com.leixiao.bytedance_2019;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        
        Set<String> first = new HashSet<>(), second = new HashSet<>();
        first.add("");
        second.add("");

        for(int i=input.length()-1; i>=0; i--){
            Set<String> cur = new HashSet<>();
            if(input.charAt(i)>'0'){

                for(String str : first){
                    cur.add((char)(input.charAt(i)-'1'+'A')+str);
                }
            }

            if(i<input.length()-1 && input.charAt(i)>'0'&&input.charAt(i)<'3'){
                int idx = Integer.parseInt(input.substring(i, i+2));

                if(idx>26){
                    continue;
                }

                for(String str: second){
                    cur.add((char)(idx-1+'A')+str);
                }
            }

            second = first;
            first = cur;
        }

        List<String> res = new ArrayList<>(first);
        Collections.sort(res);

        for (String str : res){
            System.out.println(str);
        }
    }
}
