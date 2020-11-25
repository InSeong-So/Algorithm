//[?] 원본 데이터 중에서 대상 데이터와 가장 가까운 값

/**
 * 근삿값 알고리즘(Near Algorithm): 차잇값의 절댓값의 최솟값 
 */
public class NearAlgorithm {
    //[0] 절댓값 구하기 로컬 함수
    public static int Abs(int number) {
        return (number < 0) ? -number : number; 
    }
    public static void main(String[] args) {
        //[1] Initialize
        int min = Integer.MAX_VALUE; // 차잇값의 절댓값의 최솟값이 담길 그릇

        //[2] Input
        int[] numbers = { 10, 20, 30, 27, 17 };
        int target = 25; // target과 가까운 값
        int near = 0; // 가까운 값

        //[3] Process
        for (int i = 0; i < numbers.length; i++) {
            int abs = Abs(numbers[i] - target); // 차잇값의 절댓값
            if (abs < min) {
                min = abs; // MIN: 최솟값 알고리즘
                near = numbers[i]; // NEAR: 차잇값의 절댓값의 최솟값일 때의 값
            }
        }

        //[4] Output
        System.out.println(target + "와/과 가장 가까운 값: " + near + "(차이: " + min + ")");
    }
}
