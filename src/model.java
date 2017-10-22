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
	
	public char isWinner() {		
		for(int r = 0; r < row; r++)
			if(board[r][0] == board[r][1] && board[r][0] == board[r][2] && board[r][0] != ' '){
				if(playerTurn1 == 'X') { playerTurn1 = 'O'; } else { playerTurn1 = 'X'; }
				numMoves = 10;
				return 'W';
			}		
		
		for(int c = 0; c < col; c++)
			if(board[0][c] == board[1][c] && board[0][c] == board[2][c] && board[0][c] != ' '){
				if(playerTurn1 == 'X') { playerTurn1 = 'O'; } else { playerTurn1 = 'X'; }
				numMoves = 10;
				return 'W';
			}		
		
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' '){
			if(playerTurn1 == 'X') { playerTurn1 = 'O'; } else { playerTurn1 = 'X'; }
			numMoves = 10;
			return 'W';
		}		
		
		if(board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != ' '){
			if(playerTurn1 == 'X') { playerTurn1 = 'O'; } else { playerTurn1 = 'X'; }
			numMoves = 10;
			return 'W';
		}		
		
		if(numMoves >= 9){
			numMoves++;
			return 'T';
		}
		
		return 'N';
	}

	
	public void update(int row, int column, char[][] gameBoard2, char c) {
		updatePlayerTurn(row, column, c);						
		setGameBoard(gameBoard2);
		displayGUIBoard(gameBoard2);					
		
		if(isWinner() == 'W'){
			gameView.setMessages(getPlayerTurn1(),'W');
		} else if(isWinner() == 'T')
			gameView.setMessages(getPlayerTurn1(),'T');
		
		
	}
	
	}
