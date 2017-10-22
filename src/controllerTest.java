import junit.framework.TestCase;

public class controllerTest extends TestCase {
	public void testSetMessages() throws Exception{	
		view view =new view();
		model model =new model(view);
		controller controller =new controller(model);
        assertEquals('N', controller.isWinner());
	}
}
