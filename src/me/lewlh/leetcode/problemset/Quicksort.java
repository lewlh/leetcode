package mycode;

import java.util.Random;

/**
 * https://zh.wikipedia.org/wiki/快速排序 快速排序使用分治法（Divide and
 * conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。步骤为： 1.从数列中挑出一个元素，称为"基准"（pivot），
 * 2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 * 
 * @author lewlh
 *
 */
public class Quicksort {
	int[] arr;

	private void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	private void quick_sort_recursive(int start, int end) {
		if (start >= end)
			return;
		int mid = arr[end];

		int left = start, right = end - 1;
		while (left < right) {
			while (arr[left] <= mid && left < right)
				left++;
			while (arr[right] >= mid && left < right)
				right--;
			swap(left, right);
		}
		if (arr[left] >= arr[end])
			swap(left, end);
		else
			left++;
		System.out.println(left);
		quick_sort_recursive(start, left - 1);
		quick_sort_recursive(left + 1, end);
	}

	public void sort(int[] arrin) {
		arr = arrin;
		quick_sort_recursive(0, arr.length - 1);
	}

	public static void main(String args[]) {
		Quicksort q = new Quicksort();
		int length = 20;
		int[] test = new int[length];
		Random rnd = new Random();
		for (int i = 0; i < length; i++) {
			test[i] = rnd.nextInt(1000);
			System.out.print(test[i] + "  ");
		}
		System.out.println("  ");
		q.sort(test);
		for (int i = 0; i < length; i++) {
			System.out.print(test[i] + "  ");
		}
	}
}
