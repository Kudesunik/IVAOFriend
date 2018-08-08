package ru.kunik.ivaofriend.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ru.kunik.ivaofriend.gui.atc.AtcGUIState;
import ru.kunik.ivaofriend.gui.util.AlphaContainer;
import ru.kunik.ivaofriend.listener.InitialListener;
import ru.kunik.ivaofriend.util.IVAOLanguage;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InitialGUI extends IvaoGUI {
	
	private JPanel contentPane;
	
	private JButton buttonATC;
	
	private JLabel labelIvaoStatusText;
	
	private JTextField textFieldIvaoStatusColor1;
	private JTextField textFieldIvaoStatusColor2;
	
	public InitialGUI(InitialListener listener) {
		
		super("IVAO Friend (Initializer window)");
		setResizable(false);
		
		setIconImage(programImage);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 660, 360);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
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
		gbc_labelProgramName.gridx = 2;
		gbc_labelProgramName.gridy = 0;
		contentPane.add(labelProgramName, gbc_labelProgramName);
		
		JLabel labelIvaoIcon = new JLabel("");
		labelIvaoIcon.setIcon(ivaoImageIcon);
		GridBagConstraints gbc_labelIvaoIcon = new GridBagConstraints();
		gbc_labelIvaoIcon.gridheight = 2;
		gbc_labelIvaoIcon.insets = new Insets(5, 5, 5, 5);
		gbc_labelIvaoIcon.gridx = 4;
		gbc_labelIvaoIcon.gridy = 0;
		contentPane.add(labelIvaoIcon, gbc_labelIvaoIcon);
		
		JLabel labelProgramDescription = new JLabel("Pilot and ATC helper program by Kunik");
		labelProgramDescription.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_labelProgramDescription = new GridBagConstraints();
		gbc_labelProgramDescription.insets = new Insets(5, 5, 5, 5);
		gbc_labelProgramDescription.gridx = 2;
		gbc_labelProgramDescription.gridy = 1;
		contentPane.add(labelProgramDescription, gbc_labelProgramDescription);
		
		JSeparator separatorInitializer1 = new JSeparator();
		GridBagConstraints gbc_separatorInitializer1 = new GridBagConstraints();
		gbc_separatorInitializer1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatorInitializer1.gridwidth = 5;
		gbc_separatorInitializer1.insets = new Insets(5, 5, 5, 5);
		gbc_separatorInitializer1.gridx = 0;
		gbc_separatorInitializer1.gridy = 2;
		contentPane.add(separatorInitializer1, gbc_separatorInitializer1);
		
		JLabel labelIvaoStatusTitle = new JLabel("IVAO status");
		labelIvaoStatusTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelIvaoStatusTitle = new GridBagConstraints();
		gbc_labelIvaoStatusTitle.gridwidth = 5;
		gbc_labelIvaoStatusTitle.insets = new Insets(5, 5, 5, 5);
		gbc_labelIvaoStatusTitle.gridx = 0;
		gbc_labelIvaoStatusTitle.gridy = 3;
		contentPane.add(labelIvaoStatusTitle, gbc_labelIvaoStatusTitle);
		
		textFieldIvaoStatusColor1 = new JTextField();
		textFieldIvaoStatusColor1.setEnabled(false);
		textFieldIvaoStatusColor1.setEditable(false);
		GridBagConstraints gbc_textFieldIvaoStatusColor1 = new GridBagConstraints();
		gbc_textFieldIvaoStatusColor1.gridwidth = 2;
		gbc_textFieldIvaoStatusColor1.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldIvaoStatusColor1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIvaoStatusColor1.gridx = 0;
		gbc_textFieldIvaoStatusColor1.gridy = 4;
		contentPane.add(new AlphaContainer(textFieldIvaoStatusColor1), gbc_textFieldIvaoStatusColor1);
		textFieldIvaoStatusColor1.setColumns(10);
		
		labelIvaoStatusText = new JLabel("Updating IVAO status...");
		labelIvaoStatusText.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelIvaoStatusText = new GridBagConstraints();
		gbc_labelIvaoStatusText.insets = new Insets(5, 5, 5, 5);
		gbc_labelIvaoStatusText.gridx = 2;
		gbc_labelIvaoStatusText.gridy = 4;
		contentPane.add(labelIvaoStatusText, gbc_labelIvaoStatusText);
		
		textFieldIvaoStatusColor2 = new JTextField();
		textFieldIvaoStatusColor2.setEnabled(false);
		textFieldIvaoStatusColor2.setEditable(false);
		GridBagConstraints gbc_textFieldIvaoStatusColor2 = new GridBagConstraints();
		gbc_textFieldIvaoStatusColor2.gridwidth = 2;
		gbc_textFieldIvaoStatusColor2.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldIvaoStatusColor2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIvaoStatusColor2.gridx = 3;
		gbc_textFieldIvaoStatusColor2.gridy = 4;
		contentPane.add(new AlphaContainer(textFieldIvaoStatusColor2), gbc_textFieldIvaoStatusColor2);
		textFieldIvaoStatusColor2.setColumns(10);
		
		JSeparator separatorInitializer2 = new JSeparator();
		GridBagConstraints gbc_separatorInitializer2 = new GridBagConstraints();
		gbc_separatorInitializer2.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatorInitializer2.gridwidth = 5;
		gbc_separatorInitializer2.insets = new Insets(5, 5, 5, 5);
		gbc_separatorInitializer2.gridx = 0;
		gbc_separatorInitializer2.gridy = 5;
		contentPane.add(separatorInitializer2, gbc_separatorInitializer2);
		
		JLabel labelQuestion1 = new JLabel("Choose your native language");
		labelQuestion1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelQuestion1 = new GridBagConstraints();
		gbc_labelQuestion1.gridwidth = 5;
		gbc_labelQuestion1.insets = new Insets(5, 5, 5, 5);
		gbc_labelQuestion1.gridx = 0;
		gbc_labelQuestion1.gridy = 6;
		contentPane.add(labelQuestion1, gbc_labelQuestion1);
		
		JComboBox<IVAOLanguage> comboBoxLanguage = new JComboBox<>();
		comboBoxLanguage.setModel(new DefaultComboBoxModel<IVAOLanguage>(IVAOLanguage.values()));
		GridBagConstraints gbc_comboBoxLanguage = new GridBagConstraints();
		gbc_comboBoxLanguage.gridwidth = 5;
		gbc_comboBoxLanguage.insets = new Insets(5, 5, 5, 5);
		gbc_comboBoxLanguage.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLanguage.gridx = 0;
		gbc_comboBoxLanguage.gridy = 7;
		contentPane.add(comboBoxLanguage, gbc_comboBoxLanguage);
		
		JSeparator separatorInitializer3 = new JSeparator();
		GridBagConstraints gbc_separatorInitializer3 = new GridBagConstraints();
		gbc_separatorInitializer3.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatorInitializer3.gridwidth = 5;
		gbc_separatorInitializer3.insets = new Insets(5, 5, 5, 5);
		gbc_separatorInitializer3.gridx = 0;
		gbc_separatorInitializer3.gridy = 8;
		contentPane.add(separatorInitializer3, gbc_separatorInitializer3);
		
		JLabel labelQuestion2 = new JLabel("Choose your occupation");
		labelQuestion2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelQuestion2 = new GridBagConstraints();
		gbc_labelQuestion2.gridwidth = 5;
		gbc_labelQuestion2.insets = new Insets(5, 5, 5, 5);
		gbc_labelQuestion2.gridx = 0;
		gbc_labelQuestion2.gridy = 9;
		contentPane.add(labelQuestion2, gbc_labelQuestion2);
		
		JButton buttonPilot = new JButton("Pilot");
		buttonPilot.setEnabled(false);
		buttonPilot.setName("Pilot");
		GridBagConstraints gbc_buttonPilot = new GridBagConstraints();
		gbc_buttonPilot.gridwidth = 5;
		gbc_buttonPilot.fill = GridBagConstraints.BOTH;
		gbc_buttonPilot.insets = new Insets(5, 5, 5, 5);
		gbc_buttonPilot.gridx = 0;
		gbc_buttonPilot.gridy = 10;
		contentPane.add(buttonPilot, gbc_buttonPilot);
		
		buttonPilot.addActionListener(listener);
		
		buttonATC = new JButton("Air traffic controller");
		buttonATC.setEnabled(false);
		buttonATC.setName("ATC");
		GridBagConstraints gbc_buttonATC = new GridBagConstraints();
		gbc_buttonATC.gridwidth = 5;
		gbc_buttonATC.fill = GridBagConstraints.BOTH;
		gbc_buttonATC.insets = new Insets(5, 5, 5, 5);
		gbc_buttonATC.gridx = 0;
		gbc_buttonATC.gridy = 11;
		contentPane.add(buttonATC, gbc_buttonATC);
		
		buttonATC.addActionListener(listener);
	}
	
	public void setIvaoStatus(boolean isStatusUpdated) {
		if(isStatusUpdated) {
			buttonATC.setEnabled(true);
			textFieldIvaoStatusColor1.setBackground(AtcGUIState.OK.getColor());
			textFieldIvaoStatusColor2.setBackground(AtcGUIState.OK.getColor());
			labelIvaoStatusText.setText("IVAO status successfuly updated!");
		} else {
			buttonATC.setEnabled(false);
			textFieldIvaoStatusColor1.setBackground(AtcGUIState.FAIL.getColor());
			textFieldIvaoStatusColor2.setBackground(AtcGUIState.FAIL.getColor());
			labelIvaoStatusText.setText("IVAO status update failed! Check the internet connection and restart program");
		}
	}
}
