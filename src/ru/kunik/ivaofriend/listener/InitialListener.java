package ru.kunik.ivaofriend.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ru.kunik.ivaofriend.handler.InitialHandler;

public class InitialListener implements ActionListener {
	
	private final InitialHandler initialHandler;
	
	public InitialListener(InitialHandler initialHandler) {
		this.initialHandler = initialHandler;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof JButton) {
			JButton sourceButton = (JButton) source;
			if(sourceButton.getName().equals("ATC")) {
				initialHandler.launchATC();
			}
		}
	}
}
