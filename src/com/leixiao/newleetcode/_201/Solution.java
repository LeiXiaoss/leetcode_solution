package com.leixiao.newleetcode._201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;

        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }

        return n << offset;
    }

    public int rangeBitwiseAnd1(int m, int n) {
        if (m == 0 && n == 0 ) return 0;

        int a = Integer.highestOneBit(m);
        int b = Integer.highestOneBit(n);

        if (a != b) return 0;
        return a + rangeBitwiseAnd1(m % a, n % a);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd1(5,7));
    }
}
