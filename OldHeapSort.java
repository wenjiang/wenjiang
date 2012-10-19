package pratice;

import java.util.List;

public class OldHeapSort implements Sorts {
	long sortTime = 0;

	@Override
	public void sort(List<Integer> list) {
		int length = list.size();
		//循环建堆
		for (int i = 0; i < length - 1; i++) {
			//建堆
			buildHeap(list, length - 1 - i);
			//交换堆顶和最后即最小的元素
			swap(list, 0, length - 1 - i);
		}
	}

	private void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	private void buildHeap(List<Integer> list, int lastIndex) {
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

	@Override
	public String returnName() {
		return "堆排序";
	}

	@Override
	public void setTime(long time) {
		sortTime = time;
	}

	@Override
	public long getTime() {
		return sortTime;
	}
}
