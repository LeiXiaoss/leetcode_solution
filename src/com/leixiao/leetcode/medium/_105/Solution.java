package com.leixiao.leetcode.medium._105;

import com.leixiao.leetcode.structure.TreeNode;

public class Solution {
    //根据一棵树的前序遍历与中序遍历构造二叉树。
    //
    //注意:
    //你可以假设树中没有重复的元素。
    //
    //例如，给出
    //
    //前序遍历 preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    //
    //返回如下的二叉树：
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7

    private int[] preorder,inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return dfs(0,0,inorder.length);
    }

    private TreeNode dfs(int preStart,int inStart,int inEnd){
        if(inStart >= inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int i = inStart;
        for (;i<inEnd;i++){
            if(inorder[i] == preorder[preStart]){
                break;
            }
        }

        node.left = dfs(preStart+1,inStart,i);
        node.right = dfs(preStart+1+i-inStart,i+1,inEnd);

        return node;
    }
}
