package source;

import javax.swing.JButton;

public interface controllerInterface {
	public char isWinner();
	public void reset();
	public void enableAll(JButton[][] blocks);
	public void disableAll(JButton[][] blocks);
}
