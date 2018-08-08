package ru.kunik.ivaofriend.handler;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ru.kunik.ivaofriend.gui.atc.AtcGUI;
import ru.kunik.ivaofriend.gui.atc.AtcGUIState;
import ru.kunik.ivaofriend.ivao.IvaoMetar;
import ru.kunik.ivaofriend.listener.AtcListener;

public class AtcHandler implements IHandler<AtcGUI> {
	
	private final MainHandler mainHandler;
	
	private final AtcGUI atcGUI;
	private final AtcListener atcListener;
	private final AtcUpdater atcUpdater;
	
	public AtcHandler(MainHandler mainHandler) {
		this.mainHandler = mainHandler;
		this.atcListener = new AtcListener(this);
		this.atcGUI = new AtcGUI(atcListener);
		this.atcUpdater = new AtcUpdater(this, mainHandler);
	}
	
	public boolean startATC() {
		if(isAirportInformationFilled()) {
			(new Thread(atcUpdater)).start();
			return true;
		}
		return false;
	}
	
	public void stopATC() {
		atcUpdater.stopATC();
		atcGUI.resetDynamicGUIFields();
	}
	
	@Override
	public void showGUI() {
		atcGUI.setVisible(true);
	}
	
	@Override
	public AtcGUI getGUI() {
		return atcGUI;
	}
	
	@Override
	public void hideGUI() {
		atcGUI.setVisible(false);
	}
	
	private boolean isAirportInformationFilled() {
		List<String> emptyNames = atcGUI.getEmptyInformationFields("ICAO", "Active RWY 1", "Transition level", "Transition altitude", "Squawk (start)", "Squawk (end)", "DEL frequency", "GND frequency", "TWR frequency", "APP frequency");
		if(emptyNames.isEmpty()) {
			return true;
		}
		StringBuilder errorMessage = new StringBuilder("Airport information fields not filled: ");
		for(String name : emptyNames) {
			errorMessage.append(name + ", ");
		}
		int errorMessageLength = errorMessage.length();
		errorMessage.delete(errorMessageLength - 2, errorMessageLength);
		JOptionPane.showMessageDialog(getGUI(), errorMessage.toString(), "Can't enable ATC", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	public void setupAirportInformation(String name) {
		String infoString = JOptionPane.showInputDialog(getGUI(), "Set the " + name, "Airport information setup", JOptionPane.INFORMATION_MESSAGE);
		JTextField textField = atcGUI.getInformationField(name);
		if((infoString != null) && !infoString.isEmpty()) {
			if(name.equals("ICAO") && mainHandler.getIvaoMetar().getMetar(infoString) == null) {
				JOptionPane.showMessageDialog(getGUI(), "Airport ICAO \"" + infoString + "\" does not exist in IVAO METAR!", "Can't setup ATC", JOptionPane.ERROR_MESSAGE);
			} else {
				textField.setText(infoString);
				textField.setBackground(AtcGUIState.OK.getColor());
			}
		} else {
			textField.setText("");
			if(name.equals("Active RWY 2") || name.equals("Active RWY 3")) {
				textField.setBackground(AtcGUIState.UNVERIFIABLE.getColor());
			} else {
				textField.setBackground(AtcGUIState.FAIL.getColor());
			}
			if(atcUpdater.isAtcUpdaterAlive()) {
				stopATC();
				JOptionPane.showMessageDialog(getGUI(), name + " is missed!", "Can't setup ATC", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(name.equals("ICAO")) {
			updateMetarInformation();
		}
	}
	
	public boolean updateMetarInformation() {
		IvaoMetar ivaoMetar = mainHandler.getIvaoMetar();
		String metar = ivaoMetar.getMetar(atcGUI.getInformationField("ICAO").getText());
		JTextField metarTextField = atcGUI.getInformationField("METAR");
		if((metar != null) && !metar.isEmpty()) {
			metarTextField.setText(metar);
			metarTextField.setBackground(AtcGUIState.OK.getColor());
			return true;
		} else {
			metarTextField.setText("");
			metarTextField.setBackground(AtcGUIState.FAIL.getColor());
		}
		return false;
	}
}
