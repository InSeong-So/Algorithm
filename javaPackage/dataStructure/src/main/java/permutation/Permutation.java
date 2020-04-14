package permutation;

public class Permutation {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        permutation(input, 0, input.length, input.length);
    }

    /**
     * 순서 없이 n 개중에서 r 개를 뽑는 경우
     * 사용 예시: permutation(arr, 0, n, 4);
     *
     * @param arr
     * @param depth
     * @param n
     * @param r
     */
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    /**
     * 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
     * 사용 예시: perm(arr, output, visited, 0, n, 3);
     *
     * @param arr
     * @param output
     * @param visited
     * @param depth
     * @param n
     * @param r
     */
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++)
                System.out.print(output[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
                ;
            }
        }
    }

}
