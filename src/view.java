import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;


public class view extends JFrame implements viewInterface {
	
	private JFrame gui = new JFrame("Tic Tac Toe");
	private JButton[][] blocks = new JButton[3][3];
	private JButton reset = new JButton("Reset");
	JTextArea playerturn= new JTextArea();
	private char[][] gameBoard;
	private char[][] setGameBoard;
	private char playerTurn1 = 'X';
	
	/* view constructor which set ups the gui*/
	view() {
		
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);
        
        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);
        

        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn); 
        playerturn.setText("Player 1 to play 'X'");
        		
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++){
				blocks[r][c] = new JButton(" ");
				blocks[r][c].setPreferredSize(new Dimension(75,75));
				blocks[r][c].setFocusPainted(false);
				game.add(blocks[r][c]);
			}		
					
        gui.add(gamePanel, BorderLayout.NORTH);
	}		
	
	/* method to display gui board*/
	public void displayGUIBoard( char[][] gameBoard2) {		
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++){
				getGameBoardButtons()[r][c].setText("" + gameBoard2[r][c]);
			}
	}
	
	/* set messages to show player's turn,who won the game and if the game is tied*/
	public void setMessages(char text, char c) {
		if(c=='T' && text==' '){
			playerturn.setText("Game ends in a draw");
		}
		int playerNo=1;
		if (text=='X'){
			playerNo=2;
			}
		if (c == 'W'){		
		playerturn.setText("Player " + playerNo + " wins!");
		} 
		 
		if (c=='S'){
			playerturn.setText("Player " + playerNo + " to play" + text);
		}
	}
	
	
	public char getPlayerTurn1() { return playerTurn1; }
	public JButton[][] getGameBoardButtons() { return blocks; }
	public JButton getResetButton() { return reset; }
	public void setGameBoard(char[][] gameBoard) { this.gameBoard = gameBoard;}
	public JTextArea getPlayerTurn(){ return playerturn;}
	public String getMessages() { return playerturn.getText();}
	}
