package ru.kunik.ivaofriend.handler;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import ru.kunik.ivaofriend.gui.atc.AtcGUI;

public class AtcUpdater implements Runnable {
	
	private int WHAZZUP_UPDATE_TIME_AUTO = 3000;
	private int WHAZZUP_UPDATE_TIME_MANUAL = 60000;
	
	private final AtcHandler atcHandler;
	
	private final SimpleDateFormat dateFormat;
	private final SimpleDateFormat timeFormat;
	private final Timestamp timestamp;
	
	private boolean isAtcUpdaterAlive;
	private long lastWhazzupUpdate;
	
	public AtcUpdater(AtcHandler atcHandler) {
		this.atcHandler = atcHandler;
		this.dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		this.timeFormat = new SimpleDateFormat("HH:mm:ss");
		this.timestamp = new Timestamp(System.currentTimeMillis());
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	
	@Override
	public void run() {
		isAtcUpdaterAlive = true;
		while(isAtcUpdaterAlive) {
			updateATC();
			try {
				Thread.sleep(100L);
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void updateATC() {
		long currentTime = System.currentTimeMillis();
		if((lastWhazzupUpdate + WHAZZUP_UPDATE_TIME_AUTO) < currentTime) {
			updateWhazzup();
			lastWhazzupUpdate = currentTime;
		}
		updateTimer(currentTime);
	}
	
	protected void stopATC() {
		isAtcUpdaterAlive = false;
	}
	
	private void updateTimer(long currentTime) {
		AtcGUI gui = atcHandler.getGUI();
		timestamp.setTime(System.currentTimeMillis());
		gui.getInformationField("Date").setText(dateFormat.format(timestamp));
		gui.getInformationField("Time").setText(timeFormat.format(timestamp));
	}
	
	private void updateWhazzup() {
		
	}
	
	public boolean isAtcUpdaterAlive() {
		return isAtcUpdaterAlive;
	}
}
