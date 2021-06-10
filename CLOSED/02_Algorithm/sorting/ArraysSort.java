import java.util.Comparator;

public class ArraysSort implements Comparator<Integer> {
	
	// 순차
	@Override
	public int compare(Integer o1, Integer o2) {
		return 0;
	}
	
	// 역순
	public int descCompare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}
