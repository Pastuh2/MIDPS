package org.learning.Chronometer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	private Chronometer chronometer = new Chronometer();
	private int milliseconds = 0;
	private int seconds = 0;
	private int minutes = 0;
	
	@Before
	public void setUp() {
		chronometer.setMilliseconds(milliseconds);
		chronometer.setSeconds(seconds);
		chronometer.setMinutes(minutes);
	}
	@Test
	public void testChronometerMilliseconds() {
		assertEquals(milliseconds, chronometer.getMilliseconds());
	}
	@Test(timeout=200)
	public void testChronometerSeconds() {
		assertEquals(seconds, chronometer.getSeconds());
	}
	@Test
	public void testChronometerMinutes() {
		assertEquals(minutes, chronometer.getMinutes());
	}
}
