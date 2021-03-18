package com.leixiao.newleetcode._227;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	@Test
	void calculate() {
		Solution solution = new Solution();

		Assertions.assertEquals(5, solution.calculate("3+5 / 2 "));
	}
}