package com.leixiao.newleetcode._131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private List<List<String>> res = new ArrayList<>();
	private List<String> temp = new ArrayList<>();
	private boolean[][] f;

	public List<List<String>> partition(String s) {
		f =new boolean[s.length()][s.length()];
		for (int i=0; i<s.length(); i++) {
			Arrays.fill(f[i], true);
		}

		for (int i=s.length()-1; i>=0; i--) {
			for (int j=i+1; j<s.length(); j++) {
				f[i][j] = f[i+1][j-1] && s.charAt(i) == s.charAt(j);
			}
		}

		dfs(s, 0);
		return res;
	}

	public void dfs(String s,int i) {
		if (i == s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int j = i; j < s.length(); j++) {
			if (f[i][j]) {
				temp.add(s.substring(i, j+1));
				dfs(s, j+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}
