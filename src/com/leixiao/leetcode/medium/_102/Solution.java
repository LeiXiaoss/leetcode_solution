package com.leixiao.leetcode.medium._102;

import com.leixiao.leetcode.structure.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class Solution {

    //给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    //
    //例如:
    //给定二叉树: [3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //返回其层次遍历结果：
    //
    //[
    //  [3],
    //  [9,20],
    //  [15,7]
    //]

    //使用了Javafx包下的Pair键值对，但是线上编译器可能不认这个类
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,0));

        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();

            if(level == result.size()){
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);

            if(node.left!=null){
                queue.add(new Pair<>(node.left,level+1));
            }

            if(node.right!=null){
                queue.add(new Pair<>(node.right,level+1));
            }
        }
        return result;
    }

    //使用另一种方式记录层数
    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

    //回溯法
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        addList(result,0,root);
        return result;
    }

    private void addList(List<List<Integer>> result,int level,TreeNode head){
        if(head == null) return;

        if(result.size()<=level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(head.val);

        addList(result,level+1,head.left);
        addList(result,level+1,head.right);
    }
}
