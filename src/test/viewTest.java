package test;

import source.view;
import junit.framework.TestCase;

public class viewTest extends TestCase {
	public void testSetMessages() throws Exception{	
		view view =new view();
		String message="Game ends in a draw";
		view.setMessages(' ', 'T');
        assertEquals(message, view.getMessages());
	}
}
