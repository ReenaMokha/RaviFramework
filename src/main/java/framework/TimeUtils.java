package framework;

public class TimeUtils {
	
	
	// thread .sleep-short wait
	public static void shortWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	// thread .sleep-medium wait
	public static void mediumWait() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	// thread .sleep-long wait
	public static void longWait() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
}
