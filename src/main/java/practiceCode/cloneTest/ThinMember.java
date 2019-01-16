package practiceCode.cloneTest;

public class ThinMember implements Cloneable {
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;

	public ThinMember(String id, String name, String password, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}

	public ThinMember getThinMember() {
		ThinMember cloned = null;
		try {
			cloned = (ThinMember) clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}
		return cloned;
	}
}
