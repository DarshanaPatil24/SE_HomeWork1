import junit.framework.TestCase;

public class modelTest extends TestCase {
	public void testSetMessages() throws Exception{	
		view view =new view();
		model model =new model(view);
		model.setPlayerTurn('X');
        assertEquals('X', model.getPlayerTurn1());
	}
}
