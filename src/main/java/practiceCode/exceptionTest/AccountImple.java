package practiceCode.exceptionTest;

public class AccountImple {

	public static void main(String[] args) {
		Account account = new Account();

		// 예금하기
		account.deposit(10000);
		System.out.println("예금액 : " + account.getBalance());

		// 출금하기
		try {
			account.withdraw(30000);
		} catch (BalanceInsufficientException e) {
			// 예외메세지 얻기
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			// 예외추적후 출력
			e.printStackTrace();
		}
	}
}
