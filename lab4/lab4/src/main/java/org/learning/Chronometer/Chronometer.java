package org.learning.Chronometer;

public class Chronometer {
	private int milliseconds;
	
	private int seconds;
	
	private int minutes;
	
	public int getMilliseconds() {
		return milliseconds;
	}
	
	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public void reset() {
		milliseconds = seconds = minutes = 0;
	}
	
	public void incrementMilliseconds() {
		++milliseconds;
	}
	
	public void incrementSeconds() {
		++seconds;
	}
	
	public void incrementMinutes() {
		++minutes;
	}
	
	@Override
	public String toString() {
		return String.join(":", String.valueOf(minutes), 
				String.valueOf(seconds), String.valueOf(milliseconds));
	}
}
