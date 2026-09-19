package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//main editor panel
public class EditorPanel extends JPanel{
	
	public final int FONTSIZE = 20;
	
	public final int paneLength = MainFrame.FRAMELENGTH-50;
	public final int paneWidth = MainFrame.FRAMEWIDTH - 50;
	
	public final static String EDITORPANELNAME = "Editor";
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JSpinner fontSizeSpinner; 
	private JLabel fontSpinnerLabel;
	private JButton fontColorButton;
	private JComboBox<String> fontBox;
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	
	
	public EditorPanel(TextEditor editor) {
		this.setPreferredSize(new Dimension(MainFrame.FRAMEWIDTH, MainFrame.FRAMELENGTH));
		setBackground(Color.GRAY);
		this.setLayout(new FlowLayout());
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setForeground(Color.black);
		textArea.setFont(FontFactory.getFont("Times new roman", Font.PLAIN, FONTSIZE));
		textArea.setPreferredSize(new Dimension(paneLength, paneWidth));
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(paneLength, paneWidth));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setViewportView(textArea);
		
		fontSpinnerLabel = new JLabel("Font Size");
		
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setFont(FontFactory.getFont("Arial", Font.BOLD, 13));
		fontSizeSpinner.setValue(FONTSIZE); //default font size
		
		fontColorButton = new JButton("Color");
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		fontBox = new JComboBox<>(fonts);
		fontBox.setSelectedItem("Arial"); //default arial 
		
		//menu bar code
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");

		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		this.add(fontSpinnerLabel);
		this.add(fontSizeSpinner);
		this.add(fontColorButton);
		this.add(fontBox);
		this.add(scrollPane);
	}
	
	public String toString() {
		return EDITORPANELNAME;
	}
	
	
	
	//Getters and Setters
	public JMenuBar getJMenuBar() {
		return menuBar;
	}
	
	public JSpinner getFontSizeSpinner() {
		return fontSizeSpinner;
	}

	public void setFontSizeSpinner(JSpinner fontSizeSpinner) {
		this.fontSizeSpinner = fontSizeSpinner;
	}

	public JButton getFontColorButton() {
		return fontColorButton;
	}

	public void setFontColorButton(JButton fontColorButton) {
		this.fontColorButton = fontColorButton;
	}

	public JComboBox<String> getFontBox() {
		return fontBox;
	}

	public void setFontBox(JComboBox<String> fontBox) {
		this.fontBox = fontBox;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JMenuItem getOpenItem() {
		return openItem;
	}

	public void setOpenItem(JMenuItem openItem) {
		this.openItem = openItem;
	}

	public JMenuItem getSaveItem() {
		return saveItem;
	}

	public void setSaveItem(JMenuItem saveItem) {
		this.saveItem = saveItem;
	}

	public JMenuItem getExitItem() {
		return exitItem;
	}

	public void setExitItem(JMenuItem exitItem) {
		this.exitItem = exitItem;
	}

}
