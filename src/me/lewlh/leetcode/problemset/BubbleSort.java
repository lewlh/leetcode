package mycode;

import java.util.Random;

/**
 * https://zh.wikipedia.org/wiki/冒泡排序 冒泡排序算法的运作如下： 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。 3.针对所有的元素重复以上的步骤，除了最后一个。
 * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * @author lewlh
 *
 */
public class BubbleSort {
	int[] arr;

	private void bubble_sort_recursive() {
		int i, j, temp;
		for (i = 0; i < arr.length - 1; i++)
			for (j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
	}

	public void sort(int[] arrin) {
		arr = arrin;
		bubble_sort_recursive();
	}

	public static void main(String args[]) {
		BubbleSort q = new BubbleSort();
		int length = 20;
		int[] test = new int[length];
		Random rnd = new Random();
		for (int i = 0; i < length; i++) {
			test[i] = rnd.nextInt(1000);
			System.out.print(test[i] + "  ");
		}
		System.out.println("  ");
		q.sort(test);
		System.out.println("  ");
		for (int i = 0; i < length; i++) {
			System.out.print(test[i] + "  ");
		}
	}
}
