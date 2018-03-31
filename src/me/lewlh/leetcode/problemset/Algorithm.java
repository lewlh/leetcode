package me.lewlh.leetcode.problemset;

import java.util.HashSet;

/**
 * 实现一个方法，判断输入的数字（输入是个正整数）是否为一种特殊数字，需要满足：1. 将该数字按位拆分，计算各位的平方和。2. 检查平方和值 2-1.
 * 如果等于1，则该方法返回true 2-2. 如果没出现过，则重新执行第二步。3. 如果无循环下去都无法发现平方和为1，则返回false。例： 输入数字
 * 19 1. 1^2 + 9^2 = 82 2. 8^2 + 2^2 = 68 3. 6^2 + 8^2 = 100 4. 1^2 + 0^2 + 0^2
 * = 1 ---> return true"
 * 
 * @author lewlh
 *
 */
public class Algorithm {
	public static boolean isValid(int number, HashSet<Integer> history) {
		System.out.print(number + "   ");
		if (null == history) {
			history = new HashSet<Integer>();
		}
		if (number == 1) {
			return true;
		} else if (number == 0) {
			return false;
		} else if (history.contains(new Integer(number))) {
			return false;
		}
		Integer newNum = 0;// 平方和
		int tmp = 0;
		while (number / 10 > 0) {
			number = number / 10;
			tmp = number % 10;
			newNum += tmp * tmp;
		}
		history.add(new Integer(number));
		System.out.println(newNum);
		return isValid(newNum, history);
	}

	public static void main(String[] args) {
		System.out.println(Algorithm.isValid(559873, null));
	}
}
