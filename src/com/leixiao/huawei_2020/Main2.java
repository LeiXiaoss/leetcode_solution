package com.leixiao.huawei_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main2  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] inputStr = in.nextLine().split(" ");
        int start = Integer.parseInt(inputStr[0]);
        int end = Integer.parseInt(inputStr[1]);

        int primeCount = 0;
        List<Integer> primeList = new ArrayList<>();
        List<Integer> high = new ArrayList<>(primeCount);
        List<Integer> low = new ArrayList<>(primeCount);

        for (int i=start ; i<end ; i++) {
            if (isPrime(i)) {
                primeCount++;
                primeList.add(i);
            }
        }

        if (primeCount == 0) {
            System.out.println(0);
        }



        for (Integer num : primeList) {
            String numStr = String.valueOf(num);
            char[] chars = numStr.toCharArray();

            if (chars.length<2) {
                high.add(0);
                low.add(Integer.parseInt(String.valueOf(chars[chars.length-1])));
            } else {
                high.add(Integer.parseInt(String.valueOf(chars[chars.length-2])));
                low.add(Integer.parseInt(String.valueOf(chars[chars.length-1])));
            }
        }

        int highValue = 0;
        int lowValue = 0;

        for (Integer num : high) {
            highValue += num;
        }

        for (Integer num : low) {
            lowValue += num;
        }

        System.out.println(highValue>lowValue? lowValue : highValue);
    }

    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2) return true;
        if(n%2==0) return false;
        for(int i = 3; i*i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

