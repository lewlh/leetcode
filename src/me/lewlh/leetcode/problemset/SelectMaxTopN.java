package mycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 从一组数字中获取前N个最大的值
 * 
 * @author lewlh
 *
 */
public class SelectMaxTopN {
	int topN;

	public SelectMaxTopN(int topN) {
		this.topN = topN;
	}

	public List<Integer> maxTopN(List<Integer> lst) {
		if (lst.size() <= topN)
			return lst;
		int cache = lst.remove(lst.size() - 1);
		List<Integer> newLst = maxTopN(lst);
		for (int i = 0; i < newLst.size(); i++) {
			int tmp = newLst.get(i);
			if (cache > tmp) {
				newLst.set(i, cache);
				cache = tmp;
			}
		}
		return newLst;
	}

	public static void main(String args[]) {
		SelectMaxTopN s = new SelectMaxTopN(5);
		int length = 30;
		ArrayList<Integer> test = new ArrayList<Integer>(length);
		int[] arr = new int[length];
		Random rnd = new Random();
		for (int i = 0; i < length; i++) {
			int val = rnd.nextInt(1000);
			test.add(val);
			arr[i] = val;
			System.out.print(test.get(i) + "  ");
		}
		System.out.println("  ");
		List<Integer> result = s.maxTopN(test);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "  ");
		}
		System.out.println("  ");
		SelectionSort.selection_sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

}
