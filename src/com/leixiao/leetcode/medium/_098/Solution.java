package com.leixiao.leetcode.medium._098;

import com.leixiao.leetcode.structure.TreeNode;
import sun.reflect.generics.tree.Tree;

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

    public boolean isValidBST1(TreeNode root){
        if(root == null||(root.left==null&&root.right==null)) return true;

        return isValidBST1(root, Double.MAX_VALUE, Double.MIN_VALUE);
    }

    public boolean isValidBST1(TreeNode root,double max,double min){
        if(root.val<=min || root.val>=max) return false;

        if(root.left != null){
            if(root.left.val >= root.val||
                    !isValidBST1(root.left,Math.min(root.val,max),min)){
                return false;
            }
        }

        if(root.right != null){
            if(root.right.val <= root.val||
                    !isValidBST1(root.right,max,Math.max(root.val,min))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(20);

        root.left = node1;
        root.right = node2;

        node2.left = node3;
        node2.right = node4;

        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}
