import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board extends javax.swing.JFrame implements ActionListener{
	private static JFrame frame;
	private static JPanel panel;
  private Game game;
	
	private static JButton[][] buttons;
	private final int BUTTONSIZE;
	private final int BOARDSIZE;
	private static int stBUTTONSIZE = 0;

	public Board(int buttonSize, int boardSize) {
		this.BUTTONSIZE = buttonSize;
		this.game = new Game(boardSize);
		this.BOARDSIZE = boardSize;
		stBUTTONSIZE = buttonSize;
		initializeWindow();
		initializeBoard();
	}

	private void initializeWindow() {
		frame = new JFrame();
		frame.setTitle("Tic-Tac-Toe");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(this.BOARDSIZE*this.BUTTONSIZE+35, this.BOARDSIZE*this.BUTTONSIZE+100);
		frame.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
		/*
		 * JLabel xWins = new JLabel("X wins: "); frame.add(xWins); //need to fix labels
		 */	}

	private void initializeBoard() {
		buttons = new JButton[this.BOARDSIZE][this.BOARDSIZE];
		for (int ctr = 0; ctr < buttons.length; ctr++) 
		  {
			  for (int ctr1 = 0; ctr1 < buttons[0].length; ctr1++) 
			  {
				  buttons[ctr][ctr1] = createButton(buttons[ctr][ctr1], BUTTONSIZE, BUTTONSIZE * ctr + 10, BUTTONSIZE * ctr1 + 50);
				  panel.add(buttons[ctr][ctr1]);
          buttons[ctr][ctr1].addActionListener(this);
			  }
		  }
	}
	
	private static JButton createButton(JButton button, int size, int x, int y) 
	{
		button = new JButton();
		button.setFocusable(false);
		button.setFont(new Font("Calibri", Font.PLAIN, (int)(stBUTTONSIZE * 0.7)));
		button.setBounds(x, y, size, size);
		
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		int col = (b.getBounds().y - 50) / this.BUTTONSIZE;
		int row = (b.getBounds().x - 10) / this.BUTTONSIZE;
		if (game.isLegalMove(col, row)) {
			game.doMove(col, row);
		}
	}

	public static void changeButtonText(int col, int row, int currentMove)
  {
    if (currentMove == 1)
    {
      buttons[row][col].setText("x");
    }
    else 
    {
      buttons[row][col].setText("o");
    }
  }
	public static void clearBoard() 
    {
    	for (int row = 0; row < buttons.length; row++) 
    	{
    		for (int col = 0; col < buttons.length; col++) 
    		{
    			buttons[row][col].setText("");
    		}
    	}
    }
	public static void showDialogBox(boolean isWin, int currentMove) 
	{
		if (isWin) 
		{
			String winner = "";
			if (currentMove == 1) 
				winner = "X";
			else 
				winner = "O";
			JOptionPane.showMessageDialog(null,
	                "Player " + winner +" won!",
	                "Winner!",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		else 
		{
			JOptionPane.showMessageDialog(null,
	                "Oh, it's a tie!",
	                "Tie!",
	                JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
