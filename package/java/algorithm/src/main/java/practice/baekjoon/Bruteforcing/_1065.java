import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), i, k, han=0, a[] = new int[3];
		for (i = 1; i <= n; i++) {
			if (0 < i && i < 100) han = i;
			else if (i == 1000) break;
			else {
				k = 0; int t = i;
				while (t > 0) {
					a[k] = t % 10;
					t /= 10; k++;
				}
				if (a[0] - a[1] == a[1] - a[2]) han++;
			}
		}
		System.out.println(han);
		sc.close();
	}
}