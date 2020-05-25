package model;

public class TimeKeeper {

	public static final int TIMEKEEPER=60;
	public static final int SCORE=100;
	private int time;
	private int score;
	
	
	public TimeKeeper(int time) {
		
		this.time= time;
	}
	
	public void timer () {
		
		time= TIMEKEEPER-1;
	}
	
	public int score() {
		
		score= SCORE*time;
		
		return time;
	}
	
}
