import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class controller {

	private model gameModel;
	private int numMoves = 0;
	public char text;
	public char gameBoard[][];
	
	
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
						
					}
					if(e.getSource() == resetButton) {
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
			gameModel.setPlayerTurn('X');		
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					gameBoard[r][c] = ' ';		
			numMoves = 0;
		}

}