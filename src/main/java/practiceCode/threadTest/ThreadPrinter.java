package practiceCode.threadTest;

public class ThreadPrinter implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("새로운 스레드 : " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
