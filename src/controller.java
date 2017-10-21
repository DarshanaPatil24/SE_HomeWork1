import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class controller {

	private model gameModel;
	private view gameView;
	
	
	public controller(model gameModel, view gameView) {		
	
		this.gameModel = gameModel;
		gameModel.reset();
		this.gameView = gameView;		
		ButtonListener bl = new ButtonListener();
		bl.addButtonListener(new ButtonListener());
	}


	private class ButtonListener implements ActionListener{
		JButton[][] gameBoardButtons = gameView.getGameBoardButtons();
		JButton resetButton = gameView.getResetButton();
		
		public void actionPerformed(ActionEvent e) {


			JButton[][] gameBoardButtons = gameView.getGameBoardButtons();
			char gameBoard[][] = gameModel.getBoard();
			
			JTextArea messages =gameView.getPlayerTurn();
			
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					if(e.getSource() == gameBoardButtons[r][c]){						
						
						gameModel.updatePlayerTurn(r, c, gameModel.getPlayerTurn());						
						gameView.setGameBoard(gameBoard);
						gameView.displayGUIBoard();					
						
						if(gameModel.isWinner() == 'W')
							messages.setText("Player" + gameModel.getPlayerTurn() + "wins!");							
						if(gameModel.isWinner() == 'T')
							messages.setText("Game ends in a draw");						
						
					}
					else if(e.getSource() == resetButton) {
						gameModel.reset();
						gameView.displayGUIBoard();
					}
		}
		
		public void addButtonListener(ActionListener listener) {
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					gameBoardButtons[r][c].addActionListener(listener);
			resetButton.addActionListener(listener);				
		}
	}

}