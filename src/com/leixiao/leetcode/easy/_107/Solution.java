package com.leixiao.leetcode.easy._107;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    //
    //例如：
    //给定二叉树 [3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //返回其自底向上的层次遍历为：
    //
    //[
    //  [15,7],
    //  [9,20],
    //  [3]
    //]

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        pushValue(root,0,result);

        return result;
    }

    private void pushValue(TreeNode node, int level, List<List<Integer>> result) {
        if(node == null) return;

        if(result.size() == level){
            result.add(0,new ArrayList<>());
        }

        result.get(result.size()-level-1).add(node.val);

        pushValue(node.left,level+1,result);
        pushValue(node.right,level+1,result);
    }
}
