package com.leixiao.forjob;

import com.leixiao.leetcode.structure.TreeNode;

import java.util.*;

public class TreeOperate {
    //无序数组构建一棵二叉排序树
    public static TreeNode buildArrayToBST(int[] array) {
        Arrays.sort(array);

        return addChild(array, 0, array.length-1);
    }

    public static TreeNode addChild(int[] array, int left, int right) {
        if (left > right ) return null;
        if (left == right) return new TreeNode(array[left]);

        int middle = (left + right)/2;
        TreeNode node = new TreeNode(array[middle]);
        node.left = addChild(array,left,middle-1);
        node.right = addChild(array, middle+1, right);

        return node;
    }


    //二叉树宽度（二叉树每层节点数的最大值）
    public static int getTreeWeight(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = queue.size();

        while (true) {
            int length = queue.size();
            if (length == 0) break;

            while (length>0) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            max = Math.max(queue.size(),max);
        }
        return max;
    }


    //二叉树是否对称
    //队列
    public static boolean isTreeSym(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left == null && root.right == null) return true;
        else if (root.left == null || root.right == null) return false;
        else {
            queue.add(root.left);
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            else if (left == null || right == null) return false;
            else if (left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    //递归
    public static boolean isTreeSym1(TreeNode root) {
        if (root == null) return true;
        return isEqual(root.left, root.right);
    }

    private static boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else if (left.val != right.val) return false;
        else {
            return isEqual(left.left,right.right) && isEqual(left.right, right.left);
        }
    }

    //完全二叉树的最大深度与节点个数
    public static void getTreeDeepAndNodeSize(TreeNode head) {
        int deep = 0;
        int size = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            int temp = queue.size();
            deep++;
            size += temp;
            for (int i = 0; i < temp ;i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println(deep);
        System.out.println(size);
    }


    //二叉搜索树第k个节点，不用中序遍历
    public static int kthSmallest(TreeNode root, int k) {
        int leftN = getChildNum(root.left);

        if (leftN+1 == k) return root.val;
        else if (leftN >= k) {
            return kthSmallest(root.left,k);
        } else {
            return kthSmallest(root.right, k-leftN-1);
        }
    }

    private static int getChildNum(TreeNode root) {
        if (root == null) return 0;

        return getChildNum(root.left) + getChildNum(root.right) + 1;
    }

    //判断是否为二叉搜索树
    public static boolean isBST(TreeNode root) {
        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;
        return isBST(root, max, min);
    }

    private static boolean isBST(TreeNode root, long max, long min) {
        if (root == null) return true;
        return isBST(root.left, Math.min(root.val,max), min) &&
                isBST(root.right, max, Math.max(root.val, min));
    }

    //求二叉树的深度，不使用递归
    public static int treeDeep(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count=0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode temp = queue.poll();
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
            }
            count++;
        }
        return count;
    }

    //无序数组构建一棵二叉排序树
    public static TreeNode buildBST(int[] array) {
        if (array.length == 0) return null;

        TreeNode root = new TreeNode(array[0]);

        for (int i=1 ; i<array.length ; i++) {
            TreeNode temp = root;

            while (temp != null) {
                if (temp.val > array[i]) {
                    if (temp.left == null) {
                        temp.left = new TreeNode(array[i]);
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (temp.val < array[i]) {
                    if (temp.right == null) {
                        temp.right = new TreeNode(array[i]);
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }

        return root;
    }
}
