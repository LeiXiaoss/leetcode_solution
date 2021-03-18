package com.leixiao.newleetcode._59;

public class Solution {
	public int[][] generateMatrix(int n) {
		if (n <= 0) return null;

		int left = 0;
		int right = n-1;
		int top = 0;
		int bottom = n-1;

		int[][] res = new int[n][n];
		int j = 1;
		while (left <= right && top <= bottom) {
			for (int i = left ; i <= right ; i++) {
				res[top][i] = j++;
			}

			for (int i = top+1 ; i < bottom ; i++) {
				res[i][right] = j++;
			}

			if (left < right && top < bottom) {
				for (int i = right ; i > left ; i--) {
					res[bottom][i] = j++;
				}

				for (int i = bottom ; i > top ; i--) {
					res[i][left] = j++;
				}
			}
			left++;
			top++;
			right--;
			bottom--;
		}

		return res;
	}
}
