package com.leixiao.leetcode.medium._098;

import com.leixiao.leetcode.structure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    //给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    //
    //假设一个二叉搜索树具有如下特征：
    //
    //    节点的左子树只包含小于当前节点的数。
    //    节点的右子树只包含大于当前节点的数。
    //    所有左子树和右子树自身必须也是二叉搜索树。
    //
    //示例 1:
    //
    //输入:
    //    2
    //   / \
    //  1   3
    //输出: true
    //
    //示例 2:
    //
    //输入:
    //    5
    //   / \
    //  1   4
    //     / \
    //    3   6
    //输出: false
    //解释: 输入为: [5,1,4,null,null,3,6]。
    //     根节点的值为 5 ，但是其右子节点值为 4 。

    //递归
    double last = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;

        if(isValidBST(root.left)){
            if(last<root.val){
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    //中序遍历，判断是否升序排列，全遍历，执行效率太低
    public boolean isValidBST1(TreeNode root){
        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return isOrder(list);
    }

    private boolean isOrder(List<Integer> list){
        for (int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    //这种递归更好理解
    public boolean isValidBST2(TreeNode root){
        if(root == null) return true;

        return isValidBST2(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private boolean isValidBST2(TreeNode root,long max,long min){
        if(root == null) return true;
        else if(root.val>=max||root.val<=min) return false;
        else {
            return isValidBST2(root.left,Math.min(max,root.val),min)
                    &&isValidBST2(root.right,max,Math.max(min,root.val));
        }
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node2.left = node3;
        node2.right = node4;

        Solution solution = new Solution();
        System.out.println(solution.isValidBST2(root));
    }
}
