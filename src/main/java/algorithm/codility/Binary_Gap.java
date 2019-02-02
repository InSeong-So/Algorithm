package algorithm.codility;

public class Binary_Gap {
	public static void main(String[] args) {
		int a = 1376796946;
		String s = Integer.toBinaryString(a);
		char[] as = s.toCharArray();
		int answer = 0;
		int count = 0;
		for (int i = 0; i < as.length; ++i) {
			if (as[i] == '1') {
				if (answer < count) {
					answer = count;
				}
				count = 0;
			} else {
				++count;
			}
		}
		System.out.println(answer);
	}
}
