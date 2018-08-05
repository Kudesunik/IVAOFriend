package ru.kunik.ivaofriend.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ru.kunik.ivaofriend.listener.InitialListener;
import ru.kunik.ivaofriend.util.IVAOLanguage;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class InitialGUI extends JFrame {
	
	private JPanel contentPane;
	
	private final Image programImage;
	private final Image ivaoImage;
	
	private ImageIcon programImageIcon;
	private ImageIcon ivaoImageIcon;
	
	public InitialGUI(InitialListener listener) {
		
		super("IVAO Friend (Initializer window)");
		
		this.programImage = Toolkit.getDefaultToolkit().getImage(InitialGUI.class.getResource("/ru/kunik/ivaofriend/icon/program-logo.png"));
		this.ivaoImage = Toolkit.getDefaultToolkit().getImage(InitialGUI.class.getResource("/ru/kunik/ivaofriend/icon/ivao-logo.png"));
		
		this.programImageIcon = new ImageIcon(programImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		this.ivaoImageIcon = new ImageIcon(ivaoImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		
		setIconImage(programImage);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 600, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelProgramIcon = new JLabel("");
		labelProgramIcon.setIcon(programImageIcon);
		GridBagConstraints gbc_labelProgramIcon = new GridBagConstraints();
		gbc_labelProgramIcon.gridheight = 2;
		gbc_labelProgramIcon.insets = new Insets(5, 5, 5, 5);
		gbc_labelProgramIcon.gridx = 0;
		gbc_labelProgramIcon.gridy = 0;
		contentPane.add(labelProgramIcon, gbc_labelProgramIcon);
		
		JLabel labelProgramName = new JLabel("IVAO Friend");
		labelProgramName.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		GridBagConstraints gbc_labelProgramName = new GridBagConstraints();
		gbc_labelProgramName.insets = new Insets(5, 5, 5, 5);
		gbc_labelProgramName.gridx = 1;
		gbc_labelProgramName.gridy = 0;
		contentPane.add(labelProgramName, gbc_labelProgramName);
		
		JLabel labelIvaoIcon = new JLabel("");
		labelIvaoIcon.setIcon(ivaoImageIcon);
		GridBagConstraints gbc_labelIvaoIcon = new GridBagConstraints();
		gbc_labelIvaoIcon.gridheight = 2;
		gbc_labelIvaoIcon.insets = new Insets(5, 5, 5, 5);
		gbc_labelIvaoIcon.gridx = 2;
		gbc_labelIvaoIcon.gridy = 0;
		contentPane.add(labelIvaoIcon, gbc_labelIvaoIcon);
		
		JLabel labelProgramDescription = new JLabel("Pilot and ATC helper program by Kunik");
		labelProgramDescription.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_labelProgramDescription = new GridBagConstraints();
		gbc_labelProgramDescription.insets = new Insets(5, 5, 5, 5);
		gbc_labelProgramDescription.gridx = 1;
		gbc_labelProgramDescription.gridy = 1;
		contentPane.add(labelProgramDescription, gbc_labelProgramDescription);
		
		JSeparator separatorInitializer = new JSeparator();
		GridBagConstraints gbc_separatorInitializer = new GridBagConstraints();
		gbc_separatorInitializer.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatorInitializer.gridwidth = 3;
		gbc_separatorInitializer.insets = new Insets(5, 5, 5, 0);
		gbc_separatorInitializer.gridx = 0;
		gbc_separatorInitializer.gridy = 2;
		contentPane.add(separatorInitializer, gbc_separatorInitializer);
		
		JLabel labelQuestion1 = new JLabel("Choose your native language");
		GridBagConstraints gbc_labelQuestion1 = new GridBagConstraints();
		gbc_labelQuestion1.gridwidth = 3;
		gbc_labelQuestion1.insets = new Insets(5, 5, 5, 5);
		gbc_labelQuestion1.gridx = 0;
		gbc_labelQuestion1.gridy = 3;
		contentPane.add(labelQuestion1, gbc_labelQuestion1);
		
		JComboBox<IVAOLanguage> comboBoxLanguage = new JComboBox<>();
		comboBoxLanguage.setModel(new DefaultComboBoxModel<IVAOLanguage>(IVAOLanguage.values()));
		GridBagConstraints gbc_comboBoxLanguage = new GridBagConstraints();
		gbc_comboBoxLanguage.gridwidth = 3;
		gbc_comboBoxLanguage.insets = new Insets(5, 5, 5, 5);
		gbc_comboBoxLanguage.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLanguage.gridx = 0;
		gbc_comboBoxLanguage.gridy = 4;
		contentPane.add(comboBoxLanguage, gbc_comboBoxLanguage);
		
		JLabel labelQuestion2 = new JLabel("Choose your occupation");
		GridBagConstraints gbc_labelQuestion2 = new GridBagConstraints();
		gbc_labelQuestion2.gridwidth = 3;
		gbc_labelQuestion2.insets = new Insets(5, 5, 5, 5);
		gbc_labelQuestion2.gridx = 0;
		gbc_labelQuestion2.gridy = 5;
		contentPane.add(labelQuestion2, gbc_labelQuestion2);
		
		JButton buttonPilot = new JButton("Pilot");
		buttonPilot.setEnabled(false);
		buttonPilot.setName("Pilot");
		GridBagConstraints gbc_buttonPilot = new GridBagConstraints();
		gbc_buttonPilot.gridwidth = 3;
		gbc_buttonPilot.fill = GridBagConstraints.BOTH;
		gbc_buttonPilot.insets = new Insets(5, 5, 5, 5);
		gbc_buttonPilot.gridx = 0;
		gbc_buttonPilot.gridy = 6;
		contentPane.add(buttonPilot, gbc_buttonPilot);
		
		buttonPilot.addActionListener(listener);
		
		JButton buttonATC = new JButton("Air traffic controller");
		buttonATC.setEnabled(true);
		buttonATC.setName("ATC");
		GridBagConstraints gbc_buttonATC = new GridBagConstraints();
		gbc_buttonATC.gridwidth = 3;
		gbc_buttonATC.fill = GridBagConstraints.BOTH;
		gbc_buttonATC.insets = new Insets(5, 5, 5, 5);
		gbc_buttonATC.gridx = 0;
		gbc_buttonATC.gridy = 7;
		contentPane.add(buttonATC, gbc_buttonATC);
		
		buttonATC.addActionListener(listener);
	}
}
