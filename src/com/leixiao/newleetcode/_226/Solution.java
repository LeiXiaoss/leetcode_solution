package com.leixiao.newleetcode._226;

import com.leixiao.newleetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	//先序遍历
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	//中序遍历
	public TreeNode invertTree1(TreeNode root) {
		if (root == null) return root;
		invertTree1(root.left);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree1(root.right);
		return root;
	}

	//后续遍历
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) return root;
		invertTree2(root.left);
		invertTree2(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}

	//层次遍历
	public TreeNode invertTree3(TreeNode root) {
		if (root == null) return root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
}
