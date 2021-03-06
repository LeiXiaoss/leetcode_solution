package com.leixiao.pangpang;

public class Submit4 {
    public static int getMixCase(int[] days, int iDaylen, int[] costs, int iCostLen) {
        int count = 0;

        for (int i=0;i<iDaylen;) {
            int week = 0;
            int month = 0;

            for (int j=i;j<iDaylen;j++) {
                int startDay = days[i];
                if (days[j] <= startDay+6) {
                    week++;
                }
                if (days[j] <= startDay+29) {
                    month++;
                } else {
                    break;
                }
            }
            int dayCost = costs[0];
            int weekCost = costs[1]/week;
            int monthCost = costs[2]/month;

            int min = Math.min(Math.min(dayCost, weekCost), monthCost);

            if (min == dayCost) {
                i++;
                count += costs[0];
            } else if (min == weekCost) {
                i += week;
                count += costs[1];
            } else if (min == monthCost) {
                i += month;
                count += costs[2];
            }
        }
        return count;
    }
}
