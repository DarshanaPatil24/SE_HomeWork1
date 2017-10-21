import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class controller {

	private model gameModel;
	private int numMoves = 0;
	private char text;
	public char gameBoard[][];
	
	
	public controller(model gameModel) {
	
		this.gameModel = gameModel;
		gameBoard = gameModel.getBoard();
		reset();			
		ButtonListener bl = new ButtonListener();
		bl.addButtonListener(new ButtonListener());
		
	}

	private class ButtonListener implements ActionListener{
		JButton[][] gameBoardButtons = gameModel.getGameBoardButtons();
		JButton resetButton = gameModel.getResetButton();
		public char gameBoard[][] = gameModel.getBoard();
		private char text = gameModel.getPlayerTurn1();
		public void actionPerformed(ActionEvent e) {	
			
			JTextArea messages = gameModel.getPlayerTurn();			
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					if(e.getSource() == gameBoardButtons[r][c]){			
						
						gameModel.updatePlayerTurn(r, c, gameModel.getPlayerTurn1());						
						gameModel.setGameBoard(gameBoard);
						gameModel.displayGUIBoard(gameBoard);					
						
						if(gameModel.isWinner() == 'W'){
							gameModel.passText();
						}
						if(gameModel.isWinner() == 'T')
							messages.setText("Game ends in a draw");						
						
					}
					else if(e.getSource() == resetButton) {
						reset();
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
	
		public void reset() {		
			text = 'X';		
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					gameBoard[r][c] = ' ';		
			numMoves = 0;
		}

}