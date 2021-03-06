package com.leixiao.kuaishou;

import java.util.*;

public class Main3 {
    static class Block implements Comparable{
        public int length;
        public int breadth;

        Block(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }
        @Override
        public int compareTo(Object o) {
            Block block = (Block)o;
            if (this.length > block.length) {
                return -1;
            } else if (this.length < block.length) {
                return 1;
            } else {
                if (this.breadth > block.breadth) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Block> blockList = new ArrayList<>(n);
        for (int i=0;i<n;i++) {
            blockList.add(new Block(in.nextInt(),in.nextInt()));
        }

        Collections.sort(blockList);

        return;
    }

}
