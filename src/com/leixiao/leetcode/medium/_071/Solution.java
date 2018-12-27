package com.leixiao.leetcode.medium._071;

import java.util.Stack;

public class Solution {
    //给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
    //
    //例如，
    //path = "/home/", => "/home"
    //path = "/a/./b/../../c/", => "/c"
    //
    //边界情况:
    //
    //你是否考虑了 路径 = "/../" 的情况？
    //在这种情况下，你需返回 "/" 。
    //此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
    //在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。

    public String simplifyPath(String path){
        String[] pathArray = path.split("/");

        Stack<String> pathStack = new Stack<>();

        for (int i=0;i<pathArray.length;i++){
            if(pathArray[i].equals(".")||pathArray[i].equals("")){
                continue;
            }else if(pathArray[i].equals("..")){
                if(!pathStack.isEmpty()){
                    pathStack.pop();
                }
            }else {
                pathStack.push(pathArray[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pathStack.isEmpty()){
            sb.insert(0,pathStack.pop());
            sb.insert(0,"/");
        }

        return sb.toString().isEmpty()?"/":sb.toString();
    }

    public static void main(String[] args){
        String str = "/../";
        Solution solution = new Solution();
        String pathSim = solution.simplifyPath(str);
        System.out.println(pathSim);
    }
}
