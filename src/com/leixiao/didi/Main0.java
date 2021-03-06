package com.leixiao.didi;

import java.util.*;

public class Main0 {
    static class Rule implements Comparable{
        public int small;
        public int large;

        Rule(int num1, int num2) {
            if (num1 < num2) {
                this.small = num1;
                this.large = num2;
            } else {
                this.small = num2;
                this.large = num1;
            }
        }

        @Override
        public int compareTo(Object o) {
            Rule rule = (Rule)o;

            if (this.small > rule.small) {
                return 1;
            } else if (this.small < rule.small) {
                return -1;
            } else {
                if (this.large > rule.large) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] rub = new int[n];
        List<Rule> ruleList = new ArrayList<>(m);

        for (int i=0;i<m;i++) {
            ruleList.add(new Rule(in.nextInt(),in.nextInt()));
        }
        Collections.sort(ruleList);



    }
}
