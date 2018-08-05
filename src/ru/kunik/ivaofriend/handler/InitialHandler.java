package ru.kunik.ivaofriend.handler;

import ru.kunik.ivaofriend.gui.InitialGUI;
import ru.kunik.ivaofriend.listener.InitialListener;

public class InitialHandler implements IHandler<InitialGUI> {
	
	private final MainHandler mainHandler;
	
	private final InitialGUI initialGUI;
	private final InitialListener initialListener;
	
	public InitialHandler(MainHandler mainHandler) {
		this.mainHandler = mainHandler;
		this.initialListener = new InitialListener(this);
		this.initialGUI = new InitialGUI(initialListener);
	}
	
	public void launchATC() {
		mainHandler.getInitialHandler().hideGUI();
		mainHandler.getAtcHandler().showGUI();
	}
	
	@Override
	public void showGUI() {
		initialGUI.setVisible(true);
	}
	
	@Override
	public InitialGUI getGUI() {
		return initialGUI;
	}
	
	@Override
	public void hideGUI() {
		initialGUI.setVisible(false);
	}
}
