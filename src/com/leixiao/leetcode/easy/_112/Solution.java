package com.leixiao.leetcode.easy._112;

import com.leixiao.leetcode.structure.TreeNode;

public class Solution {
    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例:
    //给定如下二叉树，以及目标和 sum = 22，
    //
    //              5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \      \
    //        7    2      1
    //
    //返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return hasPathSum(root,0,sum);
    }

    public boolean hasPathSum(TreeNode node,int temp,int sum){
        if(node == null){
            return false;
        }

        if(node.val+temp == sum && node.left == null && node.right == null){
            return true;
        }

        return hasPathSum(node.left,node.val+temp,sum)
                ||hasPathSum(node.right,node.val+temp,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);

        root.left = node1;
        root.right = node2;

        node1.left = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.right = node8;

        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(root,22));

    }
}
