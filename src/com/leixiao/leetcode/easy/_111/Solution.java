package com.leixiao.leetcode.easy._111;

import com.leixiao.leetcode.structure.TreeNode;

public class Solution {
    //给定一个二叉树，找出其最小深度。
    //
    //最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例:
    //
    //给定二叉树 [3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //返回它的最小深度  2.

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }else {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
//        root.right = node2;

//        node2.left = node3;
//        node3.right = node4;

        Solution solution = new Solution();
        int min  = solution.minDepth(root);
        System.out.println(min);
    }

}
