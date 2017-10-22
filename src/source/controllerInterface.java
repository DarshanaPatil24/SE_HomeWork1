package source;

import javax.swing.JButton;

public interface controllerInterface {
	public char isWinner()throws Exception;
	public void reset()throws Exception;
	public void enableAll(JButton[][] blocks)throws Exception;
	public void disableAll(JButton[][] blocks)throws Exception;
}
