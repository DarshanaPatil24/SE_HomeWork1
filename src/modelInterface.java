import javax.swing.JButton;
import javax.swing.JTextArea;


public interface modelInterface {	

	public void updatePlayerTurn(int xPos, int yPos, char player) ;	
	public void update(int row, int column, char[][] gameBoard2, char c);
	public void passMessages(char playerTurn12, char d) ;	
	public char[][] getBoard();
	public char getPlayerTurn1(); 
	public view getGameView();
	public JButton[][] getGameBoardButtons(); 
	public JButton getResetButton();
	public void setGameBoard(char[][] gameBoard) ;
	public void setPlayerTurn(char playerTurn1) ;
	public JTextArea getPlayerTurn();
	void displayGUIBoard(char[][] gameBoard);
	public int getNumMoves();
	public void setNumMoves(int numMoves);

}
