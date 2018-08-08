package ru.kunik.ivaofriend.handler;

import java.io.IOException;

import ru.kunik.ivaofriend.ivao.IvaoMetar;
import ru.kunik.ivaofriend.ivao.IvaoStatus;

public class MainHandler {
	
	private final InitialHandler initialHandler;
	private final AtcHandler atcHandler;
	
	private final IvaoStatus ivaoStatus;
	private final IvaoMetar ivaoMetar;
	
	public MainHandler() {
		this.initialHandler = new InitialHandler(this);
		this.atcHandler = new AtcHandler(this);
		this.ivaoStatus = new IvaoStatus();
		this.ivaoMetar = new IvaoMetar(ivaoStatus);
	}
	
	public void launchInitializer() {
		initialHandler.showGUI();
		updateIvaoStatus();
		updateIvaoMetar();
	}
	
	protected InitialHandler getInitialHandler() {
		return initialHandler;
	}
	
	protected AtcHandler getAtcHandler() {
		return atcHandler;
	}
	
	public void updateIvaoStatus() {
		try {
			this.ivaoStatus.readIvaoInformation();
			this.initialHandler.getGUI().setIvaoStatus(true);
		} catch(IOException ex) {
			this.initialHandler.getGUI().setIvaoStatus(false);
			System.err.println("Error initializing IVAO status: " + ex.toString());
		}
	}
	
	public void updateIvaoMetar() {
		try {
			this.ivaoMetar.readIvaoInformation();
		} catch(IOException ex) {
			System.err.println("Error initializing IVAO metar: " + ex.toString());
		}
	}
	
	public IvaoStatus getIvaoStatus() {
		return ivaoStatus;
	}
	
	public IvaoMetar getIvaoMetar() {
		return ivaoMetar;
	}
}
