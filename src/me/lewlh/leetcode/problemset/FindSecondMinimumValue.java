package me.lewlh.leetcode.problemset;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或
 * 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 * 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 
 * @author lewlh
 * @url https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/
 */
public class FindSecondMinimumValue {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}
	}

	public int findSecondMinimumValue(TreeNode root) {
		List<Integer> nums = this.getValue(root, null);
		if (null == nums || nums.isEmpty() || nums.size() == 1) {
			return -1;
		}
		nums.sort((Integer x, Integer y) -> x > y ? 1 : -1);
		System.out.println(nums.toString());
		int min = nums.get(0);
		for (Integer i : nums) {
			if (i > min) {
				return i;
			}
		}
		return -1;
	}

	private ArrayList<Integer> getValue(TreeNode root, ArrayList<Integer> history) {
		if (root == null) {
			return history;
		}
		if (null == history) {
			history = new ArrayList<Integer>();
		}
		history.add(root.getVal());
		if (root.left != null) {
			history = this.getValue(root.left, history);
			return this.getValue(root.right, history);
		}
		return history;
	}

	public static void main(String[] args) {
		FindSecondMinimumValue f = new FindSecondMinimumValue();
		TreeNode root = f.new TreeNode(3);
		TreeNode left = f.new TreeNode(5);
		TreeNode right = f.new TreeNode(1);
		right.setLeft(f.new TreeNode(12));
		right.setRight(f.new TreeNode(90));
		root.setLeft(left);
		root.setRight(right);
		System.out.println(f.findSecondMinimumValue(root));
	}
}
