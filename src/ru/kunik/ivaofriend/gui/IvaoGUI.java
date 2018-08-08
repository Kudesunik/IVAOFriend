package ru.kunik.ivaofriend.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class IvaoGUI extends JFrame {
	
	protected final Color ivaoColor;
	protected final Color backgroundMessageColor;
	protected final Color borderMessageColor;
	
	protected final Image programImage;
	protected final Image ivaoImage;
	
	protected final ImageIcon programImageIcon;
	protected final ImageIcon ivaoImageIcon;
	
	public IvaoGUI(String title) {
		
		super(title);
		
		this.ivaoColor = new Color(40, 74, 130);
		this.backgroundMessageColor = new Color(240, 240, 240);
		this.borderMessageColor = new Color(184, 208, 230);
		
		this.programImage = Toolkit.getDefaultToolkit().getImage(InitialGUI.class.getResource("/ru/kunik/ivaofriend/icon/program-logo.png"));
		this.ivaoImage = Toolkit.getDefaultToolkit().getImage(InitialGUI.class.getResource("/ru/kunik/ivaofriend/icon/ivao-logo.png"));
		
		this.programImageIcon = new ImageIcon(programImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		this.ivaoImageIcon = new ImageIcon(ivaoImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
	}
}
