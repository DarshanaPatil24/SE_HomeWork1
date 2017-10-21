import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class controller {

	private model gameModel;
	
	public controller(model gameModel) {
	
		this.gameModel = gameModel;
		gameModel.reset();
		ButtonListener bl = new ButtonListener();
		bl.addButtonListener(new ButtonListener());
	}

	private class ButtonListener implements ActionListener{
		JButton[][] gameBoardButtons = gameModel.getGameBoardButtons();
		JButton resetButton = gameModel.getResetButton();
		char gameBoard[][] = gameModel.getBoard();
		
		
		public void actionPerformed(ActionEvent e) {			
			
			JTextArea messages = gameModel.getPlayerTurn();
			
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					if(e.getSource() == gameBoardButtons[r][c]){						
						
						gameModel.updatePlayerTurn(r, c, gameModel.getPlayerTurn1());						
						gameModel.setGameBoard(gameBoard);
						displayGUIBoard();					
						
						if(gameModel.isWinner() == 'W'){
							char text = gameModel.getPlayerTurn1();
							int playerNo=1;
							if (text=='O')
								playerNo=2;
							messages.setText("Player " + playerNo + " wins!");	
						}
						if(gameModel.isWinner() == 'T')
							messages.setText("Game ends in a draw");						
						
					}
					else if(e.getSource() == resetButton) {
						gameModel.reset();
						displayGUIBoard();
					}
		}
		
		public void addButtonListener(ActionListener listener) {
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					gameBoardButtons[r][c].addActionListener(listener);
			resetButton.addActionListener(listener);				
		}
		
		void displayGUIBoard() {		
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++){
					gameBoardButtons[r][c].setText("" + gameBoard[r][c]);
				}
		}
	}

}