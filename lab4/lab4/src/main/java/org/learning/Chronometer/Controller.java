package org.learning.Chronometer;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Controller implements ActionListener {
	@FXML 
	private ImageView mainArrow;
	
	@FXML 
	private ImageView minuteArrow;
	
	@FXML 
	private ImageView markArrow;
	
	@FXML 
	private ImageView startButtonImage;
	
	@FXML 
	private ImageView resetButtonImage;
	
	private final int DELAY = 200;
	
	private boolean isMarkSet = false;
	
	private Chronometer chronometer = new Chronometer();
	
	private Timer timer = new Timer(DELAY, this);
	
	public void setStartButtonState() {
		if (timer.isRunning())
			timer.stop();
		else timer.start();
	}
	
	public void onStartButtonPressed() {
		startButtonImage.setVisible(true);
	}
	
	public void onStartButtonReleased() {
		startButtonImage.setVisible(false);
		setStartButtonState();
	}
	
	public void onResetButtonPressed() {
		resetButtonImage.setVisible(true);
	}
	
	public int getMainArrowPossition() {
		return chronometer.getMilliseconds() + chronometer.getSeconds() * 6;
	}
	
	public void onResetButtonReleased() {
		resetButtonImage.setVisible(false);
		if (!timer.isRunning()) {
			mainArrow.setRotate(0);
			markArrow.setRotate(0);
			minuteArrow.setRotate(0);
			chronometer.reset();
			isMarkSet = false;
		}
		else {
			markArrow.setRotate(getMainArrowPossition());
			isMarkSet = true;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		chronometer.incrementMilliseconds();
		if (chronometer.getMilliseconds() > 5) {
			chronometer.setMilliseconds(0);
			chronometer.incrementSeconds();
			if (chronometer.getSeconds() >= 60) {
				chronometer.setSeconds(0);
				chronometer.incrementMinutes();
				if (chronometer.getMinutes() >= 60)
					chronometer.reset();
			}
		}
		mainArrow.setRotate(getMainArrowPossition());
		minuteArrow.setRotate((chronometer.getMinutes() * 6 + chronometer.getSeconds() * 0.15));
		if (!isMarkSet) markArrow.setRotate(getMainArrowPossition());
		System.out.println(chronometer);
	}
}
