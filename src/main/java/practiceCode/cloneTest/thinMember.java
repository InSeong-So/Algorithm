package practiceCode.cloneTest;

public class thinMember implements Cloneable {
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;

	public thinMember(String id, String name, String password, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}

	public thinMember getThinMember() {
		thinMember cloned = null;
		try {
			cloned = (thinMember) clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}
		return cloned;
	}
}
