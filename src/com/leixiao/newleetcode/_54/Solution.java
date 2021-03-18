package com.leixiao.newleetcode._54;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (null == matrix || matrix[0].length == 0 || matrix.length == 0) {
			return res;
		}

		int left = 0;
		int right = matrix[0].length-1;
		int top = 0;
		int bottom = matrix.length-1;

		while (left <= right && top <= bottom) {
			for (int i = left ; i <= right ; i++) {
				res.add(matrix[top][i]);
			}

			for (int i= top+1 ; i <= bottom ; i++) {
				res.add(matrix[i][right]);
			}

			if (left < right && top < bottom) {
				for (int i = right-1 ; i > left ; i--) {
					res.add(matrix[bottom][i]);
				}
				for (int i = bottom ; i > top ; i--) {
					res.add(matrix[i][left]);
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return res;
	}
}
