package ru.kunik.ivaofriend.ivao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IIvaoInformation {
	
	public List<String> ivaoData = new ArrayList<>();
	
	public void readIvaoInformation() throws IOException;
}
