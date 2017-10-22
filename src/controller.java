import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class controller implements controllerInterface {

	private model gameModel;
	
	private char text;
	private char gameBoard[][];

	public controller(model gameModel) {
		this.gameModel = gameModel;
		gameBoard = gameModel.getBoard();
		reset();			
		ButtonListener bl = new ButtonListener();
		bl.addButtonListener(new ButtonListener());
		text = gameModel.getPlayerTurn1();
	}

	private class ButtonListener implements ActionListener{
		JButton[][] gameBoardButtons = gameModel.getGameBoardButtons();
		JButton resetButton = gameModel.getResetButton();
		public char gameBoard[][] = gameModel.getBoard();

		public void actionPerformed(ActionEvent e) {
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					if(e.getSource() == gameBoardButtons[r][c]){
						gameModel.update(r,c,gameBoard,gameModel.getPlayerTurn1());
						System.out.println("isWinner" + isWinner());
						char winCheck = isWinner();
						if(winCheck == 'W'){
							gameModel.passMessages(gameModel.getPlayerTurn1(),'W');
							disableAll(gameBoardButtons);
						} else if(winCheck == 'T' ){
							System.out.println("tied");
							gameModel.passMessages(' ','T');
						}
					}
			if(e.getSource() == resetButton) {
				reset();
				enableAll(gameBoardButtons);
				gameModel.displayGUIBoard(gameBoard);
			}
		}

	

		public void addButtonListener(ActionListener listener) {
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					gameBoardButtons[r][c].addActionListener(listener);
			resetButton.addActionListener(listener);				
		}
	}
	
	
	public char isWinner() {
		int numMoves =gameModel.getNumMoves();
		for(int r = 0; r < 3; r++)
			if(gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] != ' '){
				if(gameModel.getPlayerTurn1() == 'X') { gameModel.setPlayerTurn('O'); } else { gameModel.setPlayerTurn('X'); }
				numMoves = 10;
				return 'W';
			}		

		for(int c = 0; c < 3; c++)
			if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c] && gameBoard[0][c] != ' '){
				if(gameModel.getPlayerTurn1() == 'X') { gameModel.setPlayerTurn('O'); } else { gameModel.setPlayerTurn('X'); }
				numMoves = 10;
				return 'W';
			}		

		if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != ' '){
			if(gameModel.getPlayerTurn1() == 'X') { gameModel.setPlayerTurn('O'); } else { gameModel.setPlayerTurn('X'); }
			numMoves = 10;
			return 'W';
		}		

		if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] && gameBoard[2][0] != ' '){
			if(gameModel.getPlayerTurn1() == 'X') { gameModel.setPlayerTurn('O'); } else { gameModel.setPlayerTurn('X'); }
			numMoves = 10;
			return 'W';
		}		

		if(gameModel.getNumMoves() >= 9){
			numMoves++;
			System.out.println("here");
			return 'T';
		}

		return 'N';
	}

	public void enableAll(JButton[][] blocks) {
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++)
				blocks[r][c].setEnabled(true);		
	}
	
	public void disableAll(JButton[][] blocks) {
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++)
				blocks[r][c].setEnabled(false);
		}

	public void reset() {		
		gameModel.setPlayerTurn('X');		
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++)
				gameBoard[r][c] = ' ';		
		gameModel.setNumMoves(0);
	}

}