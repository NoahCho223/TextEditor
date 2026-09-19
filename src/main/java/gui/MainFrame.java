package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//main frame for text editor app
public class MainFrame extends JFrame{
	
	public static final int FRAMEWIDTH = 500;
	public static final int FRAMELENGTH = 500;
	
	JPanel panel;
	
	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Text Editor");
		this.setLayout(new BorderLayout());
		
		this.setLocationRelativeTo(null);
	}
	
	
}
