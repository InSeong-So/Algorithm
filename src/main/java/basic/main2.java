package basic;

public class main2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 4, 3};
        if (!isDistinct(A))
            System.out.println("중복데이터가 있어요!");
    }

    static int sumTest(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++)
            result += A[i];
        return result;
    }

    static int searchTest(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target)
                return i;
        }
        return -1;
    }

    static boolean isDistinct(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; i + 1 < A.length; j++) {
                if (A[i] == A[j])
                    return false;
            }
        }
        return true;
    }

    int binarySearch(int n, int[] data, int target) {
        int begin = 0;
        int end = n - 1;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (data[middle] == target)
                return middle;
            else if (data[middle] < target)
                begin = middle + 1;
            else
                end = middle - 1;
        }
        return -1;
    }
}