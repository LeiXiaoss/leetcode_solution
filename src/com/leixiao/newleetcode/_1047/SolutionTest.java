package com.leixiao.newleetcode._1047;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	@Test
	void removeDuplicates() {
		Solution solution = new Solution();
		Assertions.assertEquals("ca", solution.removeDuplicates("abbaca"));
	}
}