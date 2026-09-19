package main;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

//handles the logic of the editor
public class EditorState implements TextEditorState{
	EditorPanel editorPanel;
	
	public EditorState(TextEditor editor) {
		editorPanel = new EditorPanel(editor);
		
		
		//add actionListeners:
		JTextArea textArea = editorPanel.getTextArea();
		
		editorPanel.getFontColorButton().addActionListener(e -> {

			Color color = JColorChooser.showDialog(null, "Choose a color", textArea.getForeground());
			if(color != null) {
				textArea.setForeground(color); //change the color of text to the one chosen by user
			}
		});

		editorPanel.getFontBox().addActionListener(e -> {
			Font currentFont = textArea.getFont();
			textArea.setFont(FontFactory.getFont((String)editorPanel.getFontBox().getSelectedItem(), 
					currentFont.getStyle(), currentFont.getSize()));
		});
		
		editorPanel.getFontSizeSpinner().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(FontFactory.getFont(textArea.getFont().getFamily(), 
						Font.PLAIN, (int) editorPanel.getFontSizeSpinner().getValue()));

			}
		});
		
		JMenuItem openItem = editorPanel.getOpenItem();
		JMenuItem saveItem = editorPanel.getSaveItem();
		JMenuItem exitItem = editorPanel.getExitItem();
		
		openItem.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			//filter to only show text files
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			fileChooser.setFileFilter(filter);
			
			int response = fileChooser.showOpenDialog(editorPanel);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null; //scanner to read file to program
				
				try {
					fileIn = new Scanner(file);
					if(file.isFile()) {
						while(fileIn.hasNextLine()) {
							String line = String.format("%s \n", fileIn.nextLine());
							textArea.append(line);
						}
					}
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				finally {
					fileIn.close();
				}
			}
		});

		saveItem.addActionListener(e -> {
			
			JFileChooser fileChooser = new JFileChooser(){
				@Override
				public void approveSelection(){
					File f = getSelectedFile();
					if(f.exists() && getDialogType() == SAVE_DIALOG){
						int result = JOptionPane.showConfirmDialog(this,"The file exists, overwrite?","Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
						switch(result){

						case JOptionPane.YES_OPTION:
							super.approveSelection();
							return;
						case JOptionPane.NO_OPTION:
							return;
						case JOptionPane.CLOSED_OPTION:
							return;
						case JOptionPane.CANCEL_OPTION:
							cancelSelection();
							return;
						default:
							return;
						}
					}
					super.approveSelection();
				}        
			};
			
			fileChooser.setCurrentDirectory(new File("."));
			
			int response = fileChooser.showSaveDialog(editorPanel);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileOut = null;
				
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(textArea.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					fileOut.close();
				}
			}
		});
		
		exitItem.addActionListener(e -> {
			System.exit(0);
		});


	}
	
	public JMenuBar getJMenuBar() {
		return editorPanel.getJMenuBar();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		return editorPanel;
		
	}

}
