package me.lewlh.leetcode.problemset;

/**
 * 从排序数组中删除重复项
 * 
 * @author lewlh
 *
 */
public class RemoveDuplicates {
	/**
	 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。 不要另外定义一个数组，您必须通过用 O(1)
	 * 额外内存原地修改输入的数组来做到这一点。 给定数组: nums = [1,1,2],你的函数应该返回新长度
	 * 2,并且原数组nums的前两个元素必须是1和2 不需要理会新的数组长度后面的元素
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;
		else if (nums.length == 1) {
			return 1;
		}
		int length = nums.length;
		int tmp = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] > nums[j]) {
					tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			System.out.print(nums[i] + "  ");
		}
		System.out.println();
		int newLength = 0;
		for (int i = 0; i < length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				newLength++;
				tmp = nums[i + 1];
				nums[newLength] = tmp;
			}
		}
		for (int i = 0; i < length; i++) {
			System.out.print(nums[i] + "  ");
		}
		System.out.println();
		return newLength + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 1, 0, 1, 2, 1, 44, 1 };
		// int[] nums = { 1, 1, 2 };
		System.out.println(" " + RemoveDuplicates.removeDuplicates(nums));
	}
}
