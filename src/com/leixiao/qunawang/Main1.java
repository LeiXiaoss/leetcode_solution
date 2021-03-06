package com.leixiao.qunawang;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] mid = in.nextLine().toCharArray();
        char[] last = in.nextLine().toCharArray();

        Node node = new Node();
        build(node,last,0,mid,0,mid.length);
        sayPre(node);
    }

    public static void build(Node node, char[] a, int a1, char[] b, int b1, int size) {
        node.setValue(a[a1 + size - 1]);
        //寻找中序数组中的值与 后序数组的最后一个值 相等的位置i
        for(int i = b1; i < b1 + size; i++) {
            //如果位置i左半部分还有值，寻找后序中与左半部分对应的部分，之后build左半部分
            if(b[i] == a[a1 + size - 1]) {
                if(b1 <= i - 1) {
                    Node left = new Node();
                    node.setLeft(left);
                    build(left, a, a1, b, b1, i - b1);
                }
                //如果位置i右半部分还有值，寻找后序中与右半部分对应的部分，之后build右半部分
                if(i + 1 <= b1 + size - 1) {
                    Node right = new Node();
                    node.setRight(right);
                    build(right, a, a1 + i -b1, b, i + 1, b1 + size - 1 - i);
                }
                break;
            }
        }
    }

    //已知a为一个先序字符数组，b为一个中序字符数组，a1为a的起始点，b1为b的起始点，size为两个数组的大小
    public void build1(Node node, char[] a, int a1, char[] b, int b1, int size) {
        node.setValue(a[a1]);
        //寻找中序数组中的值与 先序数组的首个值 相等的位置i
        for(int i = b1; i < b1 + size; i++) {
            if(b[i] == a[a1] ) {
                //如果位置i左半部分还有值，寻找先序中与左半部分对应的部分，之后build左半部分
                if(i - 1 >= b1) {
                    Node left = new Node();
                    node.setLeft(left);
                    build1(left, a, a1 + 1, b, b1, i - b1);
                }
                //如果位置i右半部分还有值，寻找先序中与右半部分对应的部分，之后build右半部分
                if(i + 1 <= b1 + size - 1) {
                    Node right = new Node();
                    node.setRight(right);
                    build1(right, a, a1 + 1 + i - b1, b, i + 1, size - (i - b1) - 1);
                }
                break;
            }
        }
    }

    public static void sayPre(Node node) {
        System.out.print(node.getValue());
        if(node.getLeft() != null) sayPre(node.getLeft());
        if (node.getRight() != null) sayPre(node.getRight());
    }

    static class Node {
        public Node left;
        public Node right;
        public char value;

        public Node(char value) {
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
        public void setValue(char value) {
            this.value = value;
        }
        public char getValue() {
            return value;
        }
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
    }

}
