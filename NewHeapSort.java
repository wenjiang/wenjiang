package pratice;

import java.util.List;

public class NewHeapSort implements Sorts {
	long time = 0;

	@Override
	public void sort(List<Integer> list) {
		buildHeap(list);
		for (int i = list.size() - 1; i >= 1; i--) {
			int temp = list.get(0);
			list.set(0, list.get(i));
			list.set(i, temp);

			heapify(list, 0, i);
		}
	}

	private void heapify(List<Integer> list, int min, int max) {
		int left = 2 * min;
		int right = 2 * min + 1;
		int largest = 0;
		if ((left < max) && (list.get(left) > list.get(right))) {
			largest = left;
		} else {
			largest = min;
		}
		if ((right < max) && (list.get(right) > list.get(largest))) {
			largest = right;
		}
		if (largest != min) {
			int temp = list.get(min);
			list.set(min, list.get(largest));
			list.set(largest, temp);
			heapify(list, largest, max);
		}
	}

	private void buildHeap(List<Integer> list) {
		for (int i = (list.size() / 2 - 1); i >= 0; i--) {
			heapify(list, i, list.size());
		}
	}

	@Override
	public String returnName() {
		return "正确的堆排序";
	}

	@Override
	public void setTime(long mtime) {
		time = mtime;
	}

	@Override
	public long getTime() {
		return time;
	}
}
