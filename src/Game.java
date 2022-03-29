import java.awt.*;

public class Game{
  private int boardSize;
	int [][] moves;
  int currentMove = 1;
	public Game (int boardSize)
  {
    this.boardSize = boardSize;
    moves = new int [boardSize][boardSize];
  }

  public boolean isLegalMove(int col, int row)
  {
    if (moves[row][col] == 0)
    {
      return true;
    }
    return false;
  }

  public void doMove(int col, int row)
  {
    moves[row][col] = currentMove;
    Board.changeButtonText(col, row, currentMove);
    
    if (isThereAnyWinner()) 
    {
    	Board.showDialogBox(true, currentMove);
    	clearBoard();
    	Board.clearBoard();
    	currentMove = 0;
    }
    if (Checks.isThereATie(moves))
    {
    	Board.showDialogBox(false, 0);
    	clearBoard();
    	Board.clearBoard();
    	currentMove = 0;
    }
    currentMove++;
    
    if (currentMove > 2)
      currentMove = 1;
      
    
  }
  
  private boolean isThereAnyWinner() {
	  if (Checks.isThereAnyHorizontalWinner(moves) || Checks.isThereAnyVerticalWinner(moves) || Checks.isThereAnyNegativeDiagonalWinner(moves)
    || Checks.isThereAnyPositiveDiagonalWinner(moves))
		  return true;
	  
	  return false;
  }
  
  private void clearBoard() 
  {
	  for (int ctr = 0; ctr < moves.length; ctr++) 
	  {
		  for (int ctr1 = 0; ctr1 < moves.length; ctr1++) 
		  {
			  this.moves[ctr][ctr1] = 0;
		  }
	  }
  }
}
