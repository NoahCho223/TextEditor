package application;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.MainFrame;

//main Application for the text editor app
public class TextEditor {
	
	JFrame frame;
	
	TextEditorState mainMenuState;
	TextEditorState editorState;
	TextEditorState currentState;
	
	JPanel cards;
	
	public final static String MAINMENUPANELNAME = "Main Menu Card";
	public final static String EDITORPANELNAME = "Editor Card";
	
	CardLayout cl;
	
	public TextEditor() {
		frame = new MainFrame();

		mainMenuState = new MainMenuState(this);
		currentState = mainMenuState;
		
		cards = new JPanel(new CardLayout());
		cards.add(mainMenuState.getPanel(), mainMenuState.getPanel().toString());
		cl = (CardLayout) cards.getLayout();
		cl.show(cards, mainMenuState.getPanel().toString());
		
		frame.add(cards);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void startProgram() {
		if(editorState == null) {
			editorState = new EditorState(this);
			cards.add(editorState.getPanel(), editorState.getPanel().toString());
		}
		changeState(editorState);
	}
	
	//changes state to the given parameters
	public void changeState(TextEditorState state) {
		this.currentState=state;
		
		if (state == editorState) {
	        frame.setJMenuBar(((EditorState)editorState).getJMenuBar());
	    } else {
	        frame.setJMenuBar(null);
	    }
		
		cl.show(cards, state.getPanel().toString());
	}
	
	//For future game
		/*
		 * Mouse mouse = MainMenu.getMouseAdapter();
		 * 
		 * Create a gameState interface, and have MenuState, GameOnState implement it. These will handle the logic of each state. Pass in the listeners
		 * note: use keybindings instead of keylistener
		 * pass in the controls to each state
		 * 
		 * GameState gameOnState = new GameOnState(KeyListener, mouse);
		 * MenuState menuState = new MenuState(KeyListener, mouse);
		 * 
		 * GameState currentState;
		 * 
		 * these states are useful for runtime polymorphism of the main loop calling "currentGameState.update()"
		 * 
		 * e.g
		 * public void 
		 * 
		 */
		
		/*Main loop. For future projects, 
		@Override
		public void run() {
			final double NANO_SECONDS_PER_SECOND = 1000000000;
			double drawInterval = NANO_SECONDS_PER_SECOND/FPS;
			double delta = 0;
			long lastTime=System.nanoTime();
			long currentTime;

			//keep running until thread is closed (game closed)
			while(gameThread != null) {
				currentTime = System.nanoTime();

				delta+= (currentTime-lastTime)/drawInterval; //find how many draw intervals passed since last runtime
				lastTime = currentTime;

				if(delta>=1) { //update if passed 1 frame in time
					SwingUtilities.invokeLater(() -> { //repaint the current panel
        				currentState.getPanel().repaint();
    				});
					currentGameState.update(); //update the game state polymorphically at 60 ticks per second
					repaint();
					delta--;
				}
			}
		}
		*/

}
