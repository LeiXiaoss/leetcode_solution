package com.leixiao.newleetcode._132;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	@Test
	void minCut() {
		Solution solution = new Solution();
		Assertions.assertSame(3, solution.minCut("cabababcbc"));
	}
}