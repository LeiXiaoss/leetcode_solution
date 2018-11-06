package com.leixiao.leetcode.easy._020;

import java.util.Stack;

public class Solution {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //
    //注意空字符串可被认为是有效字符串。
    //
    //示例 1:
    //
    //输入: "()"
    //输出: true
    //
    //示例 2:
    //
    //输入: "()[]{}"
    //输出: true
    //
    //示例 3:
    //
    //输入: "(]"
    //输出: false
    //
    //示例 4:
    //
    //输入: "([)]"
    //输出: false
    //
    //示例 5:
    //
    //输入: "{[]}"
    //输出: true

    public boolean isValid(String s){
        char[] ch = s.toCharArray();
        Stack<Character> chStack = new Stack<>();

        for(int i=0;i<ch.length;i++){
            if(ch[i]=='{'||ch[i]=='['||ch[i]=='('){
                chStack.push(ch[i]);
            }else if(!chStack.isEmpty()) {
                if(chStack.peek()=='{'&&ch[i]=='}'){
                    chStack.pop();
                    continue;
                }else if(chStack.peek()=='['&&ch[i]==']'){
                    chStack.pop();
                    continue;
                }else if(chStack.peek()=='('&&ch[i]==')'){
                    chStack.pop();
                    continue;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if(!chStack.isEmpty()){
            return false;
        }
        return true;
    }
}
