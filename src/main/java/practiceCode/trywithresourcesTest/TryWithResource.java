package practiceCode.trywithresourcesTest;

public class TryWithResource {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("file.txt")) {
			fis.read();
			// 강제적으로 예외 발생
			throw new Exception();
		} catch (Exception e) {
			System.out.println("예외 처리 코드 실행");
		}
	}
}
