package com.leixiao.leetcode.easy._100;

import com.leixiao.leetcode.structure.TreeNode;

public class Solution {
    //给定两个二叉树，编写一个函数来检验它们是否相同。
    //
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    //
    //示例 1:
    //
    //输入:       1         1
    //          / \       / \
    //         2   3     2   3
    //
    //        [1,2,3],   [1,2,3]
    //
    //输出: true
    //示例 2:
    //
    //输入:      1          1
    //          /           \
    //         2             2
    //
    //        [1,2],     [1,null,2]
    //
    //输出: false
    //示例 3:
    //
    //输入:       1         1
    //          / \       / \
    //         2   1     1   2
    //
    //        [1,2,1],   [1,1,2]
    //
    //输出: false

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p!=null&&q!=null&&p.val == q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(1);

        root1.left = node11;
        root1.right = node12;

        TreeNode root2 = new TreeNode(1);
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);

        root2.left = node21;
        root2.right = node22;

        Solution solution = new Solution();
        System.out.println(solution.isSameTree(root1,root2));
    }
}
