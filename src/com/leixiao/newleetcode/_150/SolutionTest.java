package com.leixiao.newleetcode._150;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	@Test
	void evalRPN() {
		Solution solution = new Solution();
		Assertions.assertEquals(6, solution.evalRPN(new String[]{"4","13","5","/","+"}));
	}
}