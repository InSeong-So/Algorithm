/**
 *
 * 루트가 1인 트리를 1차원 배열에 저장 후 각 인덱스의 부모 노드를 출력하는 프로그램
   입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다.
   출력 : 각 인덱스의 부모 노드를 출력한다.
   예제 : 6 입력

         1
       /   \
      2     3
     / \   /
    4   5 6
 *
 * 포화 이진 트리이거나 완전 이진 트리이므로 1차원 배열 n+1 만큼 번호 순서대로 저장한다. 
 */
import java.util.*;

public class Tree1Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
				// tree를 표현 할 1차원 배열, 루트는 1부터 시작하기 때문에 n+1 한다.
        int[] parent = new int[n + 1];
				// 1은 루트이기 때문에 2부터 시작한다. (tree[1] = 0)
        for (int i = 2; i <= n; i++) {
						// 노드i의 부모 노드 인덱스 = i/2
            parent[i] = i / 2;
        }
				// 결과 출력
        System.out.println(Arrays.toString(parent));
    }
}