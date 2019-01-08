package classTest;

public class Car {
//	// 객체 생성 테스트
//	private String model;
//	private String color;
//	private int maxSpeed;
//
//	Car(String model) {
//		this(model, "silver", 250);
//	}
//
//	Car(String model, String color) {
//		this(model, "black", 3000);
//	}
//
//	Car(String model, String color, int maxSpeed) {
//		this.model = model;
//		this.color = color;
//		this.maxSpeed = maxSpeed;
//	}
//
//	public String toString() {
//		return model + ", " + color + ", " + maxSpeed;
//	}
//
//	public static void main(String[] args) {
//		Car car = new Car("재규어", "tor");
//		System.out.println(car.toString());
//	}

	// 필드
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);

	// 생성자

	// 메소드
	int run() {
		System.out.println("자동차가 달리기 시작합니다.");
		if (frontLeftTire.roll() == false) {
			stop();
			return 1;
		}
		if (frontRightTire.roll() == false) {
			stop();
			return 2;
		}
		if (backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if (backRightTire.roll() == false) {
			stop();
			return 4;
		}
		return 0;
	}

	void stop() {
		System.out.println("자동차가 멈췄습니다.");
	}
}
