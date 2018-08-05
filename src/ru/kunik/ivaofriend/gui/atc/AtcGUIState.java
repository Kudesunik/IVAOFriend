package ru.kunik.ivaofriend.gui.atc;

import java.awt.Color;

public enum AtcGUIState {
	
	/* @formatter:off */
	
	OK(60, 220, 60), 
	UNVERIFIABLE(60, 60, 220), 
	FAIL(220, 60, 60);
	
	/* @formatter:on */
	
	private Color color;
	
	AtcGUIState(int red, int green, int blue) {
		this.color = new Color(red, green, blue, 64);
	}
	
	public Color getColor() {
		return color;
	}
}
