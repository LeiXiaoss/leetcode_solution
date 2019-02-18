package com.leixiao.leetcode.easy._101;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    //给定一个二叉树，检查它是否是镜像对称的。
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    //
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //
    //但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    //
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3
    //
    //说明:
    //
    //如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

    //迭代
    //使用队列
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) continue;
            else if (left == null || right == null) return false;
            else if(left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

    //递归
    public boolean isSymmetric1(TreeNode root){
        if (root == null) return true;
        return isSymmetric1(root.left,root.right);
    }

    private boolean isSymmetric1(TreeNode left,TreeNode right){
        if(left == null && right == null) {
            return true;
        }else if(left == null || right == null) {
            return false;
        }else if(left.val != right.val) {
            return false;
        }else {
            return isSymmetric1(left.left,right.right)&&isSymmetric1(left.right,right.left);
        }
    }
}
