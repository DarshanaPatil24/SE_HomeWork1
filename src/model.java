import javax.swing.JButton;
import javax.swing.JTextArea;

public class model {	

	private int row = 3;
	private int col = 3;
	private char board[][] = new char[row][col];
	public char playerTurn1 = 'X';
	private int numMoves = 0;
	private view gameView;
	private char[][] gameBoard;
	public JTextArea playerturn;
	public JButton[][] blocks;
	private controller c;


	public char[][] getBoard() { return board; }
	public char getPlayerTurn1() { return playerTurn1; }
	public view getGameView() { return gameView;}
	public JButton[][] getGameBoardButtons() { return gameView.getGameBoardButtons(); }
	public JButton getResetButton() { return gameView.getResetButton(); }
	public void setGameBoard(char[][] gameBoard) { this.gameBoard = gameBoard;}
	public void setPlayerTurn(char playerTurn1) { this.playerTurn1 = playerTurn1;}
	public JTextArea getPlayerTurn(){ return gameView.playerturn;}	
	void displayGUIBoard(char[][] gameBoard) {	
		gameView.displayGUIBoard(gameBoard);
	}

	public model(view view){
		this.gameView = view;	
	}

	public void updatePlayerTurn(int xPos, int yPos, char player) {		
		if(board[xPos][yPos] == ' ' && numMoves < 10) {			
			board[xPos][yPos] = player;		
			if(player == 'X'){
				board[xPos][yPos] = playerTurn1;
				playerTurn1 = 'O';
				gameView.setMessages('O', 'S');
			}
			else{
				board[xPos][yPos] = playerTurn1;
				playerTurn1 = 'X';
				gameView.setMessages('X', 'S');
			}			
			numMoves++;
		}
	}
	
	public void update(int row, int column, char[][] gameBoard2, char c) {
		updatePlayerTurn(row, column, c);
		gameView.displayGUIBoard(gameBoard2);
	}
	
	public void passMessages(char playerTurn12, char d) {
		gameView.setMessages(playerTurn12,d);

	}

}
