package com.leixiao.leetcode.hard._099;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    //二叉搜索树中的两个节点被错误地交换。
    //
    //请在不改变其结构的情况下，恢复这棵树。
    //
    //示例 1:
    //
    //输入: [1,3,null,null,2]
    //
    //   1
    //  /
    // 3
    //  \
    //   2
    //
    //输出: [3,1,null,null,2]
    //
    //   3
    //  /
    // 1
    //  \
    //   2
    //示例 2:
    //
    //输入: [3,1,4,null,null,2]
    //
    //  3
    // / \
    //1   4
    //   /
    //  2
    //
    //输出: [2,1,4,null,null,3]
    //
    //  2
    // / \
    //1   4
    //   /
    //  3
    //进阶:
    //
    //使用 O(n) 空间复杂度的解法很容易实现。
    //你能想出一个只使用常数空间的解决方案吗？

    //这个方法做了很多次遍历，还有很大改进空间
    public void recoverTree(TreeNode root) {
        //获取中序遍历
        List<Integer> list = inOrder(root);

        //查找需要交换的节点
        int small=list.get(1),big=list.get(0);
        int index = 0;

        for (int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                big = list.get(i);
                index = i;
                break;
            }
        }

        for (int i=index;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                small = list.get(i+1);
            }
        }

        recoverTree(root,small,big);
    }

    private void recoverTree(TreeNode root,int small,int big){
        TreeNode smallNode = root;
        TreeNode bigNode = root;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();

                if (root.val == big){
                    bigNode = root;
                }
                if(root.val == small){
                    smallNode = root;
                    break;
                }

                root = root.right;
            }
        }

        smallNode.val = big;
        bigNode.val = small;
    }

    //中序遍历
    private List inOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root != null){
            List leftList = inOrder(root.left);
            result.addAll(leftList);

            result.add(root.val);

            List rightList = inOrder(root.right);
            result.addAll(rightList);
        }
        return result;
    }

    //常数空间的解法
    TreeNode preNode;
    TreeNode smallNode;
    TreeNode bigNode;
    public void removeTree(TreeNode root){
        dfs(root);

        int temp = bigNode.val;
        bigNode.val = smallNode.val;
        smallNode.val = temp;
    }

    private void dfs(TreeNode root){
        if(root.left != null){
            dfs(root.left);
        }

        if(preNode == null || preNode.val > root.val){
            if(bigNode == null){
                bigNode = preNode;
            }
            smallNode = root;
        }

        preNode = root;

        if(root.right != null){
            dfs(root.right);
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);

        root.left = node1;
//        root.right = node2;

        node1.right = node2;

        Solution solution = new Solution();
        solution.recoverTree(root);
        return;
    }
}
