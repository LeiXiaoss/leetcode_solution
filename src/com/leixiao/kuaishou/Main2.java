package com.leixiao.kuaishou;

import java.util.Scanner;

public class Main2 {
    public static StringBuilder sb = new StringBuilder();
    static class Node {
        public Node left;
        public Node right;
        public int value;
        public int sum;

        public Node(int value) {
            this.value = value;
        }
        public Node() {

        }

        public void setLeft(Node left) {
            this.left = left;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] preStr = in.nextLine().split(" ");
        String[] midStr = in.nextLine().split(" ");

        int[] pre = new int[preStr.length];
        int[] mid = new int[midStr.length];

        for (int i=0;i<pre.length;i++) {
            pre[i] = Integer.parseInt(preStr[i]);
            mid[i] = Integer.parseInt(midStr[i]);
        }

        Node node = new Node();
        build(node, pre, 0, mid, 0, pre.length);
        buildSumTree(node);
        sayMid(node);

        System.out.println(sb.toString().trim());
    }

    //已知a为一个先序字符数组，b为一个中序字符数组，a1为a的起始点，b1为b的起始点，size为两个数组的大小
    public static void build(Node node, int[] a, int a1, int[] b, int b1, int size) {
        node.setValue(a[a1]);
        //寻找中序数组中的值与 先序数组的首个值 相等的位置i
        for(int i = b1; i < b1 + size; i++) {
            if(b[i] == a[a1] ) {
                //如果位置i左半部分还有值，寻找先序中与左半部分对应的部分，之后build左半部分
                if(i - 1 >= b1) {
                    Node left = new Node();
                    node.setLeft(left);
                    build(left, a, a1 + 1, b, b1, i - b1);
                }
                //如果位置i右半部分还有值，寻找先序中与右半部分对应的部分，之后build右半部分
                if(i + 1 <= b1 + size - 1) {
                    Node right = new Node();
                    node.setRight(right);
                    build(right, a, a1 + 1 + i - b1, b, i + 1, size - (i - b1) - 1);
                }
                break;
            }
        }
    }

    public static void buildSumTree(Node node) {
        if (node.left == null && node.right == null) {
            node.sum = 0;
            return;
        }

        if (node.left != null) {
            buildSumTree(node.left);
        }

        if (node.right != null) {
            buildSumTree(node.right);
        }

        if (node.left != null && node.right == null) {
            node.sum = node.left.value + node.left.sum;
        } else if (node.right != null && node.left == null) {
            node.sum = node.right.value + node.right.sum;
        } else if (node.left != null && node.right != null) {
            node.sum = node.left.value + node.right.value +
                    node.left.sum + node.right.sum;
        }
    }

    public static void sayAfter(Node node) {
        if(node.getLeft() != null) sayAfter(node.getLeft());
        if (node.getRight() != null) sayAfter(node.getRight());
        sb.append(node.sum);
        sb.append(" ");
    }

    public static void sayMid(Node node) {
        if (node.getLeft() != null) sayMid(node.getLeft());
        sb.append(node.sum);
        sb.append(" ");
        if (node.getRight() != null) sayMid(node.getRight());
    }
}
