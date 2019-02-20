package com.leixiao.leetcode.easy._110;

import com.leixiao.leetcode.structure.TreeNode;

public class Solution {
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //
    //本题中，一棵高度平衡二叉树定义为：
    //
    //    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    //
    //示例 1:
    //
    //给定二叉树 [3,9,20,null,null,15,7]
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //返回 true 。
    //    //
    //示例 2:
    //
    //给定二叉树 [1,2,2,3,3,null,null,4,4]
    //
    //       1
    //      / \
    //     2   2
    //    / \
    //   3   3
    //  / \
    // 4   4
    //
    //返回 false 。

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        if(Math.abs(level(root.left)-level(root.right))>1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int level(TreeNode node){
        if(node == null) return 0;

        return Math.max(level(node.left),level(node.right))+1;
    }


    //时间复杂度优于前一种，记录了之前计算的节点的平衡情况。
    public boolean isBalance1(TreeNode root){
        return maxDepth(root)!=-1;
    }

    private int maxDepth(TreeNode node){
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if(left == -1 || right == -1 || Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}
