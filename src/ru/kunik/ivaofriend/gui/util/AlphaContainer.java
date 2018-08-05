package ru.kunik.ivaofriend.gui.util;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class AlphaContainer extends JComponent {
	
	private final JComponent component;
	
	public AlphaContainer(JComponent component) {
		this.component = component;
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		component.setOpaque(false);
		this.add(component);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		graphics.setColor(component.getBackground());
		graphics.fillRect(0, 0, getWidth(), getHeight());
	}
}
