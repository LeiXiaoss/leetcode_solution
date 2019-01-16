package com.leixiao.leetcode.hard._099;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    //二叉搜索树中的两个节点被错误地交换。
    //
    //请在不改变其结构的情况下，恢复这棵树。
    //
    //示例 1:
    //
    //输入: [1,3,null,null,2]
    //
    //   1
    //  /
    // 3
    //  \
    //   2
    //
    //输出: [3,1,null,null,2]
    //
    //   3
    //  /
    // 1
    //  \
    //   2
    //示例 2:
    //
    //输入: [3,1,4,null,null,2]
    //
    //  3
    // / \
    //1   4
    //   /
    //  2
    //
    //输出: [2,1,4,null,null,3]
    //
    //  2
    // / \
    //1   4
    //   /
    //  3
    //进阶:
    //
    //使用 O(n) 空间复杂度的解法很容易实现。
    //你能想出一个只使用常数空间的解决方案吗？

    public void recoverTree(TreeNode root) {
        List<Integer> list = inOrder(root);

        int first=list.get(1),last=list.get(0);
        for (int i=0;i<list.size()-1;i++){
            if(list.get(i) > list.get(i+1)){
                first = list.get(i+1);
            }
        }

        for (int i=1;i<first;i++){
            if(list.get(i-1)<list.get(first)&&list.get(i+1)>list.get(first)){
                last = list.get(i);
            }
        }

        recoverTree(root,first,last);
    }

    private void recoverTree(TreeNode root,int first,int last){
        TreeNode beforeNode = root;
        TreeNode afterNode = root;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();

                if (root.val == last){
                    afterNode = root;
                }
                if(root.val == first){
                    beforeNode = root;
                    break;
                }

                root = root.right;
            }
        }


    }

    private List inOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root != null){
            List leftList = inOrder(root.left);
            result.addAll(leftList);

            result.add(root.val);

            List rightList = inOrder(root.right);
            result.addAll(rightList);
        }
        return result;
    }
}
