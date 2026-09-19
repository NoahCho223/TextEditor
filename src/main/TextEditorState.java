package main;

import javax.swing.JPanel;

//Each state of the text editor updates the screen and draws the screen differently
public interface TextEditorState{
	
	public void update();
	
	public JPanel getPanel();
}
