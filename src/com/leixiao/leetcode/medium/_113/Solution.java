package com.leixiao.leetcode.medium._113;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
    //         /  \    / \
    //        7    2  5   1
    //
    //返回:
    //
    //[
    //   [5,4,11,2],
    //   [5,8,4,5]
    //]

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List result = new ArrayList();

        dfs(result,sum,root,new ArrayList<>(),0);

        return result;
    }

    private void dfs(List result,int total,TreeNode node,List<Integer> temp,int sum){
        if(node == null) return;

        if(node.val+sum == total && node.left == null && node.right == null){
            temp.add(node.val);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        temp.add(node.val);

        dfs(result,total,node.left,temp,sum+node.val);
        dfs(result,total,node.right,temp,sum+node.val);
        temp.remove(temp.size()-1);
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
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.left = node1;
        root.right = node2;

        node1.left = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;

        Solution solution = new Solution();
        List result = solution.pathSum(root,22);

        System.out.println(result);
    }
}
