package ru.kunik.ivaofriend.handler;

public class MainHandler {
	
	private final InitialHandler initialHandler;
	private final AtcHandler atcHandler;
	
	public MainHandler() {
		this.initialHandler = new InitialHandler(this);
		this.atcHandler = new AtcHandler(this);
	}
	
	public void launchInitializer() {
		initialHandler.showGUI();
	}
	
	protected InitialHandler getInitialHandler() {
		return initialHandler;
	}
	
	protected AtcHandler getAtcHandler() {
		return atcHandler;
	}
}
