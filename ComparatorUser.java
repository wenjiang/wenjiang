package pratice;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class ComparatorUser implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		/*
		 * User user0 = (User) arg0; User user1 = (User) arg1;
		 * 
		 * int flag = (user0.getName()).compareTo((user1.getName())); if (flag
		 * == 0) { return -((user0.getAge() + "").compareTo(user1.getAge() +
		 * "")); } else { return -flag; }
		 */

		String obj0 = arg0 + "";
		String obj1 = arg1 + "";
		int flag = 0;
		if (obj0.length() < obj1.length()) {
			flag = -1;
		} else if (obj0.length() == obj1.length()) {
			flag = obj0.compareTo(obj1);
		} else {
			flag = 1;
		}
		return flag;
	}
}
