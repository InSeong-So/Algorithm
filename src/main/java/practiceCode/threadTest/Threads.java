package practiceCode.threadTest;

public class Threads {

	public static void main(String[] args) throws InterruptedException {
		final Thread separateThread = new Thread(new ThreadPrinter());
		separateThread.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("메인 스레드 : " + Thread.currentThread().getName());
			Thread.sleep(1000);
		}

	}
}
