package com.leixiao.leetcode.medium._094;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    //给定一个二叉树，返回它的中序 遍历。
    //
    //示例:
    //
    //输入: [1,null,2,3]
    //   1
    //    \
    //     2
    //    /
    //   3
    //
    //输出: [1,3,2]
    //进阶: 递归算法很简单，你可以通过迭代算法完成吗？

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if (root != null){
            List leftList = inorderTraversal(root.left);
            result.addAll(leftList);
            result.add(root.val);

            List rightList = inorderTraversal(root.right);
            result.addAll(rightList);
            return result;
        }else {
            return result;
        }
    }

    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
