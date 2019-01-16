package practiceCode.stringTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class StringTest {

	/* String 생성자들
	 *
	 * 배열 전체를 String 객체로 생성
	 * String str = new String(byte[] bytes);
	 * 
	 * 지정한 문자셋으로 디코딩
	 * String str = new String(byte[] bytes, String charsetName);
	 * 
	 * 배열의 offset 인덱스 위치부터 length만큼 String 객체로 생성
	 * String str = new String(byte[] bytes, int offset, int length);
	 * 
	 * 지정한 문자셋으로 디코딩
	 * String str = new String(byte[] bytes, int offset, int length, String charsetName); 
	 * */

	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);

		System.out.println("-------------- 메소드 실행 --------------");

		// try {
		// KeyboardToString();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		StringGetBytes();
	}

	static void KeyboardToString() throws IOException {
		// 읽은 바이트를 저장하기 위한 배열 생성
		byte[] bytes = new byte[100];

		System.out.print("입력 : ");
		// 배열에 읽은 바이트를 저장하고 읽은 바이트 수를 리턴
		int readByteNo = System.in.read(bytes);
		// 입력받은 값의 바이트 수
		System.out.println(readByteNo);
		// 배열을 문자열로 변환
		String str = new String(bytes, 0, readByteNo - 2);
		System.out.println(str);
	}

	static void StringGetBytes() {
		String str = "안녕하세요";

		try {

			// 기본 문자 셋으로 인코딩하기
			byte[] bytes1 = str.getBytes();
			System.out.println("bytes1.length : " + bytes1.length);
			String str1 = new String(bytes1);
			System.out.println("bytes1 -> String : " + str1);

			// UTF-8로 인코딩 및 디코딩하기
			byte[] bytes2 = str.getBytes("UTF-8");
			System.out.println("bytes2.length : " + bytes2.length);
			String str2 = new String(bytes2, "UTF-8");
			System.out.println("bytes2 -> String : " + str2);

			// UTF-8로 인코딩 및 디코딩하기
			byte[] bytes3 = str.getBytes("EUC-KR");
			System.out.println("bytes3.length : " + bytes3.length);
			String str3 = new String(bytes3, "EUC-KR");
			System.out.println("bytes3 -> String : " + str3);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
