public class TicTacToe {

	public static void main(String[] args) {
		view gameView = new view();
		model gameModel = new model(gameView);
		controller gameController = new controller(gameModel);	
		
	}
}