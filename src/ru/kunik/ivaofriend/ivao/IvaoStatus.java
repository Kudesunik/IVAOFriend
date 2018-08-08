package ru.kunik.ivaofriend.ivao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IvaoStatus implements IIvaoInformation {
	
	private static String ivaoStatusAddress = "http://www.ivao.aero/whazzup/status.txt";
	
	private URL ivaoStatusURL;
	
	private String ivaoMessage;
	private String ivaoWhazzupUncompressedLink;
	private String ivaoWhazzupCompressedLink;
	private String ivaoMetarLink;
	
	public IvaoStatus() {
		try {
			this.ivaoStatusURL = new URL(ivaoStatusAddress);
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void readIvaoInformation() throws IOException {
		ivaoData.clear();
		URLConnection ivaoStatusConnection = ivaoStatusURL.openConnection();
		InputStream ivaoStatusInputStream = ivaoStatusConnection.getInputStream();
		BufferedReader ivaoStatusReader = new BufferedReader(new InputStreamReader(ivaoStatusInputStream));
		for(String ivaoStatusLine = null; (ivaoStatusLine = ivaoStatusReader.readLine()) != null;) {
			ivaoData.add(ivaoStatusLine);
		}
		parseIvaoInformation();
	}
	
	private void parseIvaoInformation() {
		for(String ivaoStatusLine : ivaoData) {
			if(!ivaoStatusLine.contains("=")) {
				continue;
			}
			String[] resultArray = ivaoStatusLine.split("=");
			String result = (resultArray.length > 1) ? resultArray[1] : null;
			if(ivaoStatusLine.contains("msg0")) {
				this.ivaoMessage = result;
			} else if(ivaoStatusLine.contains("url0")) {
				if(ivaoStatusLine.contains("gz")) {
					this.ivaoWhazzupCompressedLink = result;
				} else {
					this.ivaoWhazzupUncompressedLink = result;
				}
			} else if(ivaoStatusLine.contains("metar0")) {
				this.ivaoMetarLink = result;
			}
		}
	}
	
	public String getIvaoMessage() {
		return ivaoMessage;
	}
	
	public String getWhazzupUncompressedLink() {
		return ivaoWhazzupUncompressedLink;
	}
	
	public String getWhazzupCompressedLink() {
		return ivaoWhazzupCompressedLink;
	}
	
	public String getMetarLink() {
		return ivaoMetarLink;
	}
}
