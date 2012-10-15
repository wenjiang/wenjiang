package pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.R.integer;

public class AllOfSort {
	// 插入排序
	public static void sort1(List<Integer> list) {
		int temp = 0;
		for (int i = 1; i < list.size(); i++) {
			int j = i - 1;
			temp = list.get(i);
			while (j >= 0 && temp < list.get(j)) {
				list.set(j + 1, list.get(j));
				j--;
			}
			list.set(j + 1, temp);
		}
	}

	// 希尔排序
	public void sort2(List<Integer> list) {
		double len = list.size();
		int temp = 0;
		while (true) {
			len = Math.ceil(len / 2);
			int l = (int) len;
			for (int i = 0; i < l; i++) {
				for (int j = i + l; j < list.size(); j += l) {
					int d = j - l;
					temp = list.get(j);
					while ((d >= 0) && (temp < list.get(d))) {
						list.set(d + l, list.get(d));
						d -= l;
					}
					list.set(d + l, temp);
				}
			}
			if (l == 1) {
				break;
			}
		}
	}

	// 简单选择排序
	public void sort3(List<Integer> list) {
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			int j = i + 1;
			index = i;
			int temp = list.get(i);
			while (j < list.size()) {
				if (list.get(j) < temp) {
					temp = list.get(j);
					index = j;
				}
				j++;
			}
			list.set(index, list.get(i));
			list.set(i, temp);
		}
	}

	// 堆排序
	public void sort4(List<Integer> list) {
		int length = list.size();
		for (int i = 0; i < length - 1; i++) {
			buildMaxHeap(list, length - 1 - i);
			swap(list, 0, length - 1 - i);
		}
	}

	private void buildMaxHeap(List<Integer> list, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int j = i;
			while (j * 2 + 1 <= lastIndex) {
				int biggerIndex = 2 * j + 1;
				if (biggerIndex < lastIndex) {
					if (list.get(biggerIndex) < list.get(biggerIndex + 1)) {
						biggerIndex++;
					}
				}
				if (list.get(j) < list.get(biggerIndex)) {
					swap(list, j, biggerIndex);
					j = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	private void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	// 冒泡排序
	public void sort5(List<Integer> list) {
		int temp = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				if (list.get(j) > list.get(j + 1)) {
					temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}

	// 快速排序
	public void sort6(List<Integer> list) {
		if (list.size() > 0) {
			quickSort(list, 0, list.size() - 1);
		}
	}

	private void quickSort(List<Integer> list, int left, int right) {
		if (left < right) {
			int middle = getMiddle(list, left, right);
			quickSort(list, left, middle - 1);
			quickSort(list, middle + 1, right);
		}

	}

	private int getMiddle(List<Integer> list, int left, int right) {
		int temp = list.get(left);
		while (left < right) {
			while ((left < right) && (list.get(right) >= temp)) {
				right--;
			}
			list.set(left, list.get(right));
			while ((left < right) && (list.get(left) <= temp)) {
				left++;
			}
			list.set(right, list.get(left));
		}
		list.set(left, temp);
		return left;
	}

	// 归并排序
	public void sort7(List<Integer> list) {
		sort(list, 0, list.size() - 1);
	}

	private void sort(List<Integer> list, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			sort(list, left, center);
			sort(list, center + 1, right);
			merge(list, left, center, right);
		}
	}

	private void merge(List<Integer> list, int left, int center, int right) {
		List<Integer> mlist = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			mlist.add(0);
		}
		int mid = center + 1;
		int third = left;
		int temp = left;
		while ((left <= center) && (mid <= right)) {
			if (list.get(left) <= list.get(mid)) {
				mlist.set(third, list.get(left));
				third++;
				left++;
			} else {
				mlist.set(third, list.get(mid));
				third++;
				mid++;
			}
		}
		while (mid <= right) {
			mlist.set(third, list.get(mid));
			third++;
			mid++;
		}
		while (left <= center) {
			mlist.set(third, list.get(left));
			third++;
			left++;
		}
		while (temp <= right) {
			int mtemp = temp;
			list.set(temp, mlist.get(mtemp));
			mtemp++;
			temp = mtemp;
		}
	}

	// 基数排序
	public static void sort8(List<Integer> list) {
		sortList(list);
	}

	private static void sortList(List<Integer> list) {
		int max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		int time = 0;
		while (max > 0) {
			max /= 10;
			time++;
		}
		List<List<Integer>> queue = new ArrayList<List<Integer>>();
		for (int i = 0; i < 10; i++) {
			List<Integer> mqueue = new ArrayList<Integer>();
			queue.add(mqueue);
		}
		for (int i = 0; i < time; i++) {
			for (int j = 0; j < list.size(); j++) {
				int x = (list.get(j) % (int) Math.pow(10, i + 1) / (int) Math
						.pow(10, i));
				List<Integer> nqueue = queue.get(x);
				nqueue.add(list.get(j));
				queue.set(x, nqueue);
			}
			int count = 0;
			for (int j = 0; j < 10; j++) {
				while (queue.get(j).size() > 0) {
					List<Integer> lqueue = queue.get(j);
					list.set(count, lqueue.get(0));
					lqueue.remove(0);
					count++;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void sort9(List<Integer> list) {
		ComparatorUser comparator = new ComparatorUser();
		Collections.sort(list, comparator);
	}
}
