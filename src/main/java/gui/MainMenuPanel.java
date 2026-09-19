package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import application.FontFactory;
import application.TextEditor;

public class MainMenuPanel extends JPanel{
	
	public final static String MAINMENUPANELNAME = "Main Menu";
	
	JLabel welcomeText;
	JButton startButton;
	
	//main menu and application gui panels to swap between the frame based on state
	TextEditor application;
	TextEditor mainMenu;
	
	int FONTSIZE = 20;
	
	public MainMenuPanel(TextEditor application) {
		this.application = application;
		this.setPreferredSize(new Dimension(MainFrame.FRAMELENGTH, MainFrame.FRAMEWIDTH));
		this.setLayout(new BorderLayout());
		
		welcomeText = new JLabel();
		welcomeText.setFont(FontFactory.getFont("Arial", Font.PLAIN, 50));
		welcomeText.setForeground(new Color(25,255,0));
		welcomeText.setText("Text Editor Program");
		welcomeText.setOpaque(true);
		
		startButton = new JButton();
		startButton.setFont(FontFactory.getFont("MV Boli", Font.BOLD, FONTSIZE));
		startButton.setPreferredSize(new Dimension(30,30));
		startButton.setText("Start");
		startButton.setFocusable(false);
		
		startButton.addActionListener(e -> {
			application.startProgram();
		});
		
		JPanel buttonPanel = new JPanel(new GridLayout(0,1,10,0));
		buttonPanel.add(startButton);
		
		this.add(welcomeText, BorderLayout.NORTH);
		//this.add(new JSeparator(), BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	public String toString() {
		return MAINMENUPANELNAME;
	}

}
