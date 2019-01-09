package practiceCode.enumTest;

// 열거형 상수 연결 테스트
enum Type {

	WALKING("워킹화", 1), RUNNING("러닝화", 2), TRACKING("트래킹화", 3), HIKING("등산화", 4);

	final private String name;
	final private int branch;

	private Type(String name, int branch) {
		this.name = name;
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public int getBranch() {
		return branch;
	}
}

public class Shoes {
	public static void main(String[] args) {
		for (Type type : Type.values()) {
			System.out.println(type.getBranch() + " : " + type.getName());
		}
	}
}