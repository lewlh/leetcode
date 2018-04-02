package me.lewlh.leetcode.problemset;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * @author lewlh
 * @url https://leetcode-cn.com/problems/combinations/description/
 *
 */
public class Combine {
	public static List<List<Integer>> combine(int n, int k) {
		if (n < 0 || k < 0 || k > n)
			return new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		int start = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		DFS(n, k, start, result, list);
		List<List<Integer>> r = result;
		return r;
	}

	/**
	 * 深度优先
	 * 
	 * @param n
	 *            1，2，3，······,n
	 * @param k
	 *            k个数的组合
	 * @param start
	 * @param result
	 *            结果集
	 * @param list
	 *            临时结果
	 */
	public static void DFS(int n, int k, int start, ArrayList<List<Integer>> result, ArrayList<Integer> list) {
		System.out.println("start=[" + start + "],list=" + list);
		System.out.println("result=" + result);
		if (list.size() == k) {
			List<Integer> tmp = new ArrayList<Integer>(list);
			result.add(tmp);
			return;
		}
		for (int i = start; i <= n; i++) {
			list.add(i);
			DFS(n, k, i + 1, result, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// System.out.println(Combine.combine(1, 1));
		System.out.println(Combine.combine(5, 4));
	}
}
