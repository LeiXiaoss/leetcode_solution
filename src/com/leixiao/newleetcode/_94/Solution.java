package com.leixiao.newleetcode._94;

import com.leixiao.newleetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if (null != root) {
			inorderTraversal(root.left);
			res.add(root.val);
			inorderTraversal(root.right);
		}
		return res;
	}

	public  List<Integer> inorderTraversal1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
}
