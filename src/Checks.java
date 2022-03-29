
public class Checks {
	public static boolean isThereAnyVerticalWinner(int [][] moves) {
		  for (int row = 0; row < moves.length; row++)
	    {
	      for (int col = 0; col < moves.length; col++)
	      {
	        if (moves[row][col] == 0 || moves[row][col] != moves[row][0])
	        {
	         break;
	        }
	        if (col == moves.length - 1)
	          return true;
	      }
	    }
		  
		  return false;
	  }

	  public static boolean isThereAnyHorizontalWinner(int [][] moves)
	  {
	    for (int col = 0; col < moves.length; col++)
	    {
	      for (int row = 0; row < moves.length; row++)
	      {
	        if (moves[row][col] == 0 || moves[row][col] != moves[0][col])
	        {
	         break;
	        }
	        if (row == moves.length - 1)
	          return true;
	      }
	    }
		  
		  return false;
	  }

	  public static boolean isThereAnyNegativeDiagonalWinner(int [][] moves)
	  {
	    for (int ctr = 0; ctr < moves.length; ctr++)
	    {
	      if (moves[ctr][ctr] == 0 || moves[ctr][ctr] != moves[0][0])
	      {
	        return false;
	      }
	    }
	    return true;
	  }

	  public static boolean isThereAnyPositiveDiagonalWinner(int [][] moves)
	  {
		  for (int ctr = 0; ctr < moves.length; ctr++)
		  {
			  if (moves[moves.length - 1][0] != moves[ctr][moves.length - 1 - ctr] || moves[ctr][moves.length - 1 - ctr] == 0) 
			  {
				  return false;
			  }
		  }
		  return true;
	  }

	  public static boolean isThereATie(int [][] moves)
	  {
	    for (int ctr = 0; ctr < moves.length; ctr++)
	    {
	      for (int ctr1 = 0; ctr1 < moves.length; ctr1++)
	      {
	        if (moves[ctr][ctr1] == 0)
	          return false;
	      }
	    }
	    return true;
	  }
}
