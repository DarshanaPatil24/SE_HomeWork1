package source;

import javax.swing.JButton;
import javax.swing.JTextArea;


public interface viewInterface {
	public void displayGUIBoard( char[][] gameBoard2)throws Exception;	
	public void setMessages(char text, char c) throws NullPointerException;
	public char getPlayerTurn1() throws Exception;
	public JButton[][] getGameBoardButtons()throws Exception; 
	public JButton getResetButton() throws Exception;
	public void setGameBoard(char[][] gameBoard)throws Exception ;
	public JTextArea getPlayerTurn()throws Exception;
	public String getMessages() throws Exception;
}
