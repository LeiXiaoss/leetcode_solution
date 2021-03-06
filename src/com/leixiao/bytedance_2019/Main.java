package com.leixiao.bytedance_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class ErrorSection implements Comparable {
        public int start;
        public int end;

        public ErrorSection(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "," + end;
        }

        @Override
        public int compareTo(Object o) {
            ErrorSection errorSection = (ErrorSection) o;
            if (this.start > errorSection.start) {
                return 1;
            } else if (this.start < errorSection.start) {
                return  -1;
            } else {
                if (this.end >= errorSection.end) {
                    return 1;
                } else if (this.end < errorSection.end) {
                    return -1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        List<ErrorSection> errorList = new ArrayList<>();
        List<ErrorSection> errorResult = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            String[] section = in.nextLine().split(";");
            for (String str : section) {
                String[] nums = str.split(",");
                errorList.add(new ErrorSection(Integer.parseInt(nums[0]),
                        Integer.parseInt(nums[1])));
            }
        }

        Collections.sort(errorList);

        errorList.forEach(section -> {
            if (errorResult.isEmpty()) {
                errorResult.add(section);
            } else {
                ErrorSection temp = errorResult.get(errorResult.size()-1);

                if (temp.end < section.start-1) {
                    errorResult.add(section);
                } else {
                    temp.end = Math.max(temp.end, section.end);
                }
            }

        });

        for (int i = 0 ; i < errorResult.size() ; i++) {
            if (i == errorResult.size() -1) {
                System.out.print(errorResult.get(i).toString());
            } else {
                System.out.print(errorResult.get(i).toString() + ";");
            }
        }

        return;
    }
}
