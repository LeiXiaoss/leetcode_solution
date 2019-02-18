package com.leixiao.leetcode.medium._103;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.*;

public class Solution {
    //给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
    //返回锯齿形层次遍历如下：
    //
    //[
    //  [3],
    //  [20,9],
    //  [15,7]
    //]

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            while (size>0){
                TreeNode node = queue.poll();

                if(level%2 == 0){
                    temp.add(node.val);
                }else {
                    temp.add(0,node.val);
                }

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);

                size--;
            }
            result.add(temp);
            level++;
        }
        return result;
    }
}
