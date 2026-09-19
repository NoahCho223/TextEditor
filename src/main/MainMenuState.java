package main;

import javax.swing.JPanel;

public class MainMenuState implements TextEditorState{
	
	/*for a larger program like a game, can utilize a list of entities that you would pass to the panel, and that panel will paint all of the
	 * entities
	 * 
	*/
	
	JPanel mainMenuPanel;
	
	public MainMenuState(TextEditor editor) {
		mainMenuPanel = new MainMenuPanel(editor);
	}
	
	//update main menu logic. Won't need this for this program, as everything is done via buttons and such. On a game program, will update 60 ticks per second
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public JPanel getPanel() {
		return mainMenuPanel;
	}

}
