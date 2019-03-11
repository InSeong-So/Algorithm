package doit2.chap02;
// 배열을 복제합니다.

class CloneArray {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = a.clone();			// b는 a의 복제를 참조

		b[3] = 0;						// 한 요소에만 0 대입

		System.out.print("a =");
		for (int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);

		System.out.print("\nb =");
		for (int i = 0; i < b.length; i++)
			System.out.print(" " + b[i]);
	}
}