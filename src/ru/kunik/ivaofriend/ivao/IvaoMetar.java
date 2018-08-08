package ru.kunik.ivaofriend.ivao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class IvaoMetar implements IIvaoInformation {
	
	private final IvaoStatus ivaoStatus;
	
	private final Map<String, String> ivaoMetarMap;
	
	public IvaoMetar(IvaoStatus ivaoStatus) {
		this.ivaoStatus = ivaoStatus;
		this.ivaoMetarMap = new HashMap<>();
	}
	
	@Override
	public void readIvaoInformation() throws IOException {
		ivaoData.clear();
		URL ivaoMetarURL = new URL(ivaoStatus.getMetarLink());
		URLConnection ivaoStatusConnection = ivaoMetarURL.openConnection();
		InputStream ivaoStatusInputStream = ivaoStatusConnection.getInputStream();
		BufferedReader ivaoStatusReader = new BufferedReader(new InputStreamReader(ivaoStatusInputStream));
		for(String ivaoStatusLine = null; (ivaoStatusLine = ivaoStatusReader.readLine()) != null;) {
			ivaoData.add(ivaoStatusLine);
		}
		parseIvaoInformation();
	}
	
	private void parseIvaoInformation() {
		for(String ivaoMetarLine : ivaoData) {
			String[] metarArray = ivaoMetarLine.split(" ");
			ivaoMetarMap.put(metarArray[0], ivaoMetarLine);
		}
	}
	
	public String getMetar(String airportICAO) {
		if(ivaoMetarMap.containsKey(airportICAO)) {
			return ivaoMetarMap.get(airportICAO);
		}
		return null;
	}
}
