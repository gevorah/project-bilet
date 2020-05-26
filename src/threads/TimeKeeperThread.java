package threads;

public class TimeKeeperThread extends Thread {

	private int time;
	private boolean exit;

	public TimeKeeperThread() {
		
		
		time = 60;
		
		setDaemon(true);
	}

	public void run() {
		exit = false;

		while (!exit && time > 0) {
			time -= 1;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Excepcion Hilo Cortado: " + e.getMessage());
			}
		}

		System.out.println("Sale. Tiempo ->" + time);
	}

	public int getTime() {
		return time;
	}

	public void stopThread() {

		exit = true;
	}
}
