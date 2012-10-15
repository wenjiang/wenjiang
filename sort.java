package pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100000; i++) {
			list.add(new Random().nextInt(100000));
		}
		showTimeOfSort(9, list);
		showTimeOfSort(3, list);
		showTimeOfSort(1, list);
		showTimeOfSort(2, list);
		showTimeOfSort(4, list);
		showTimeOfSort(5, list);
		showTimeOfSort(7, list);
		showTimeOfSort(8, list);
		showTimeOfSort(6, list);
	}

	@SuppressWarnings({ "static-access" })
	private static void showTimeOfSort(int i, List<Integer> list) {
		AllOfSort sorts = new AllOfSort();
		String str = "";
		long startTime = 0;
		long endTime = 0;
		switch (i) {
		case 1:
			str = "插入排序";
			startTime = System.currentTimeMillis();
			sorts.sort1(list);
			endTime = System.currentTimeMillis();
			break;
		case 2:
			str = "希尔排序";
			startTime = System.currentTimeMillis();
			sorts.sort2(list);
			endTime = System.currentTimeMillis();
			break;
		case 3:
			str = "简单选择排序";
			startTime = System.currentTimeMillis();
			sorts.sort3(list);
			endTime = System.currentTimeMillis();
			break;
		case 4:
			str = "堆排序";
			startTime = System.currentTimeMillis();
			sorts.sort4(list);
			endTime = System.currentTimeMillis();
			break;
		case 5:
			str = "冒泡排序";
			startTime = System.currentTimeMillis();
			sorts.sort5(list);
			endTime = System.currentTimeMillis();
			break;
		case 6:
			str = "快速排序";
			startTime = System.currentTimeMillis();
			sorts.sort6(list);
			endTime = System.currentTimeMillis();
			break;
		case 7:
			str = "归并排序";
			startTime = System.currentTimeMillis();
			sorts.sort7(list);
			endTime = System.currentTimeMillis();
			break;
		case 8:
			str = "基数排序";
			startTime = System.currentTimeMillis();
			sorts.sort8(list);
			endTime = System.currentTimeMillis();
			break;
		case 9:
			str = "list.sort";
			startTime = System.currentTimeMillis();
			sorts.sort9(list);
			endTime = System.currentTimeMillis();
			break;
		}
		// show(list);
		System.out.println(str + "的排序时间为:" + " " + (endTime - startTime));
	}

	private static void show(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
