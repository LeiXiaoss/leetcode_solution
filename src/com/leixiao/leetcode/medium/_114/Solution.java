package com.leixiao.leetcode.medium._114;

import com.leixiao.leetcode.structure.TreeNode;

public class Solution {
    //给定一个二叉树，原地将它展开为链表。
    //
    //例如，给定二叉树
    //
    //    1
    //   / \
    //  2   5
    // / \   \
    //3   4   6
    //
    //将其展开为：
    //
    //1
    // \
    //  2
    //   \
    //    3
    //     \
    //      4
    //       \
    //        5
    //         \
    //          6

    public void flatten(TreeNode root){
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        while (root.left != null){
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.right = root.left;
            root.left = null;

            while (left.right!=null){
                left = left.right;
            }
            left.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;

        Solution solution = new Solution();
        solution.flatten(root);
        return;
    }
}
