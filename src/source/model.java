package source;

import javax.swing.JButton;
import javax.swing.JTextArea;

public final class model implements modelInterface {	

	private int row = 3;
	private int col = 3;
	private char board[][] = new char[row][col];
	private char playerTurn1 = 'X';
	private int numMoves = 0;
	private view gameView;
	private char[][] gameBoard;
	private JTextArea playerturn;
	private JButton[][] blocks;


	public char[][] getBoard() { return board; }
	public char getPlayerTurn1() { return playerTurn1; }
	public view getGameView() { return gameView;}
	public JButton[][] getGameBoardButtons() { return gameView.getGameBoardButtons(); }
	public JButton getResetButton() { return gameView.getResetButton(); }
	public void setGameBoard(char[][] gameBoard) { this.gameBoard = gameBoard;}
	public void setPlayerTurn(char playerTurn1) { this.playerTurn1 = playerTurn1;}
	public JTextArea getPlayerTurn(){ return gameView.playerturn;}	
	public int getNumMoves(){ return numMoves;}	
	public void setNumMoves(int numMoves){ this.numMoves=numMoves;}
	public void displayGUIBoard(char[][] gameBoard) {gameView.displayGUIBoard(gameBoard);}

	public model(view view){
		this.gameView = view;	
	}

	/* method to switch between players*/
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
	
	/* update model and display the gui board*/
	public void update(int row, int column, char[][] Board, char playerInput) {
		updatePlayerTurn(row, column, playerInput);
		setGameBoard(Board);
		gameView.displayGUIBoard(Board);
	}
	
	public void passMessages(char playerInput, char winCheck) {
		gameView.setMessages(playerInput,winCheck);

	}

}
