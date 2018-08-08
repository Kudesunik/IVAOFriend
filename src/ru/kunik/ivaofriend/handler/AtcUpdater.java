package ru.kunik.ivaofriend.handler;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.swing.JOptionPane;

import ru.kunik.ivaofriend.gui.atc.AtcGUI;

public class AtcUpdater implements Runnable {
	
	private long WHAZZUP_UPDATE_TIME_AUTO = 1000 * 30; //30 seconds
	private long METAR_UPDATE_TIME_AUTO = 1000 * 60 * 5; //5 minutes
	private long WHAZZUP_UPDATE_TIME_MANUAL = 1000 * 60; //1 minutes
	
	private final AtcHandler atcHandler;
	private final MainHandler mainHandler;
	
	private final SimpleDateFormat dateFormat;
	private final SimpleDateFormat timeFormat;
	private final Timestamp timestamp;
	
	private boolean isAtcUpdaterAlive;
	
	private long lastWhazzupUpdate;
	private long lastMetarUpdate;
	
	public AtcUpdater(AtcHandler atcHandler, MainHandler mainHandler) {
		this.atcHandler = atcHandler;
		this.mainHandler = mainHandler;
		this.dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		this.timeFormat = new SimpleDateFormat("HH:mm:ss");
		this.timestamp = new Timestamp(System.currentTimeMillis());
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	
	@Override
	public void run() {
		isAtcUpdaterAlive = true;
		lastWhazzupUpdate = 0;
		lastMetarUpdate = 0;
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
		if((lastMetarUpdate + METAR_UPDATE_TIME_AUTO) < currentTime) {
			updateMetar();
			lastMetarUpdate = currentTime;
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
	
	private void updateMetar() {
		try {
			mainHandler.getIvaoMetar().readIvaoInformation();
			atcHandler.updateMetarInformation();
		} catch(IOException ex) {
			System.err.println("Error updating IVAO METAR: " + ex.toString());
			atcHandler.stopATC();
			JOptionPane.showMessageDialog(atcHandler.getGUI(), "Can not update IVAO METAR information!", "Can't update ATC", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean isAtcUpdaterAlive() {
		return isAtcUpdaterAlive;
	}
}
