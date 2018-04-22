package mycode;

import java.util.Random;

/**
 * https://zh.wikipedia.org/wiki/插入排序 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 1.从第一个元素开始，该元素可以认为已经被排序 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置 5.将新元素插入到该位置后
 * 6.重复步骤2~5
 * 
 * @author lewlh
 *
 */
public class InsertionSort {
	public static void insertion_sort1(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j - 1] <= arr[j])
					break;
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				System.out.println("  ");
				for (int m = 0; m < arr.length; m++) {
					System.out.print(arr[m] + "  ");
				}
			}
		}
	}

	public static void insertion_sort2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			for (; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
			for (int m = 0; m < arr.length; m++) {
				System.out.print(arr[m] + "  ");
			}
			System.out.println("  " + temp);
		}
	}

	public static void main(String args[]) {
		int length = 10;
		int[] test = new int[length];
		Random rnd = new Random();
		for (int i = 0; i < length; i++) {
			test[i] = rnd.nextInt(1000);
			System.out.print(test[i] + "  ");
		}
		System.out.println("  ");
		InsertionSort.insertion_sort2(test);
		System.out.println("  ");
		for (int i = 0; i < length; i++) {
			System.out.print(test[i] + "  ");
		}
	}
}
