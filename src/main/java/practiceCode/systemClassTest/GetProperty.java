package practiceCode.systemClassTest;

import java.util.Properties;
import java.util.Set;

public class GetProperty {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");

		System.out.println("운영체제 이름 : " + osName);
		System.out.println("사용자 이름 : " + userName);
		System.out.println("사용자 홈 디렉토리 : " + userHome);

		System.out.println("-----------------------------");
		System.out.println(" [ Key ] value");
		System.out.println("-----------------------------");

		// 모든 (키, 값) 쌍을 저장하고 있는 Properties 객체를 리턴한다.
		Properties props = System.getProperties();
		// 해당 객체의 keySet() 메소드를 호출하면 키만으로 구성된 Set 객체를 얻을 수 있다.
		Set keys = props.keySet();
		for (Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println(" [ " + key + " ] " + value);
		}

		System.out.println("-----------------------------");

		// 환경 변수 읽기
		String javaHome = System.getenv("JAVA_HOME");
		System.out.println("JAVA_HOME : " + javaHome);
	}
}
