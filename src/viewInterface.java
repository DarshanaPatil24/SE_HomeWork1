import javax.swing.JButton;
import javax.swing.JTextArea;


public interface viewInterface {
	public void displayGUIBoard( char[][] gameBoard2);	
	public void setMessages(char text, char c);
	public char getPlayerTurn1() ;
	public JButton[][] getGameBoardButtons(); 
	public JButton getResetButton() ;
	public void setGameBoard(char[][] gameBoard) ;
	public JTextArea getPlayerTurn();
	public String getMessages() ;
}
