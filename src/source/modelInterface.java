package source;

import javax.swing.JButton;
import javax.swing.JTextArea;


public interface modelInterface {	

	public void updatePlayerTurn(int xPos, int yPos, char player) throws Exception ;	
	public void update(int row, int column, char[][] gameBoard2, char c) throws Exception;
	public void passMessages(char playerTurn12, char d) throws Exception;	
	public char[][] getBoard()throws Exception;
	public char getPlayerTurn1()throws Exception; 
	public view getGameView()throws Exception;
	public JButton[][] getGameBoardButtons()throws Exception; 
	public JButton getResetButton()throws Exception;
	public void setGameBoard(char[][] gameBoard)throws Exception ;
	public void setPlayerTurn(char playerTurn1) throws Exception;
	public JTextArea getPlayerTurn()throws Exception;
	void displayGUIBoard(char[][] gameBoard)throws Exception;
	public int getNumMoves()throws Exception;
	public void setNumMoves(int numMoves)throws Exception;

}
