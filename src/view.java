import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;


public class view extends JFrame{
	
	public JFrame gui = new JFrame("Tic Tac Toe");
    public JButton[][] blocks = new JButton[3][3];
    public JButton reset = new JButton("Reset");
    public JTextArea playerturn= new JTextArea();
    private char[][] gameBoard;
	public char[][] setGameBoard;
	private char playerTurn1 = 'X';
	
    
	
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
	
	public void displayGUIBoard( char[][] gameBoard2) {		
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++){
				getGameBoardButtons()[r][c].setText("" + gameBoard2[r][c]);
			}
	}
	
	public void setMessages(char text, char c){
		int playerNo=1;
		if (text=='O'){
			playerNo=2;
			}
		if (c == 'W'){		
		playerturn.setText("Player " + playerNo + " wins!");
		} else if(c=='T'){
			playerturn.setText("Game ends in a draw");
		} else if (c=='S'){
			playerturn.setText("Player " + playerNo + " to play" + text);
		}
	}
	
	
	public char getPlayerTurn1() { return playerTurn1; }
	public JButton[][] getGameBoardButtons() { return blocks; }
	public JButton getResetButton() { return reset; }
	public void setGameBoard(char[][] gameBoard) { this.gameBoard = gameBoard;}
	public JTextArea getPlayerTurn(){ return playerturn;}
	}
