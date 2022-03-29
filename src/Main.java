import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		  int buttonSize = 0, boardSize = 0; Scanner sc = new Scanner(System.in);
		  System.out.println("What button size do you want?"); buttonSize =
		  sc.nextInt(); System.out.println("What board size do you want?"); boardSize =
		  sc.nextInt();
		 
		 
	   Board board = new Board(buttonSize, boardSize);
	}
}
