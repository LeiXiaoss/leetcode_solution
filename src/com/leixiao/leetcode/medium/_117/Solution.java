package com.leixiao.leetcode.medium._117;

import java.util.*;

public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> list = new ArrayList<>();
            do {
                list.add(queue.poll());
            }while (!queue.isEmpty());

            for (int i = 0; i < list.size() - 1;  i++) {
                list.get(i).next = list.get(i+1);
            }

            for (int i = 0; i < list.size(); i++) {
                Node temp = list.get(i);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node_1 = new Node(2);
        Node node_2 = new Node(3);
        Node node_3 = new Node(4);
        Node node_4 = new Node(5);
        Node node_5 = new Node(7);

        root.left = node_1;
        root.right = node_2;

        node_1.left = node_3;
        node_1.right = node_4;

        node_2.right = node_5;

        Solution solution = new Solution();

        solution.connect(root);
        return;
    }
}
