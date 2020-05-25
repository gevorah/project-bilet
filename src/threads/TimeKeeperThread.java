package threads;

import model.TimeKeeper;

public class TimeKeeperThread extends Thread {

	private int time;
	private int score;
	private TimeKeeper tk; 

	public TimeKeeperThread(int time, int score, TimeKeeper tk) {

		this.time = time;
		this.score = score;
		tk= new TimeKeeper(time);
	}

	public void run() {
		
		tk.timer();
		score= tk.score();
		
		
	}
}
