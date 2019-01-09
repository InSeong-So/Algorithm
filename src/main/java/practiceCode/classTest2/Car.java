package practiceCode.classTest2;

public class Car {

	// 필드
	// 동일한 타입의 값들이므로 배열로 관리
	Tire[] tires = { new Tire("앞왼쪽", 6), new Tire("앞오른쪽", 2), new Tire("뒤왼쪽", 3), new Tire("뒤오른쪽", 4) };

	// 메소드
	int run() {
		System.out.println("[ 자동차가 달리기 시작합니다. ]");
		for (int i = 0; i < tires.length; i++) {
			if (tires[i].roll() == false) {
				stop();
				return (i + 1);
			}
		}
		return 0;
	}

	void stop() {
		System.out.println("[ 자동차가 멈췄습니다. ]");
	}
}
