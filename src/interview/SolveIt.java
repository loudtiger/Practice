
public class SolveIt {

	static int[][] gameBoard = 
		{{5, -1, -1, -1, -1, 6, -1, -1, 1},
	     {1, -1, 2, 8, -1, 4, 3, -1, 6},
	     {8, -1, -1, 1, 3, -1, 2, -1, 7},
	     {-1, -1, -1, -1, 5, 9, 7, -1, 3},
	     {-1, -1, -1, -1, -1, -1, -1, -1, -1},
	     {7, -1, 4, 3, 6, -1, -1, -1, -1},
	     {9, -1, 7, -1, 4, 1, -1, -1, 2},
	     {6, -1, 5, 7, -1, 3, 1, -1, 4},
	     {4, -1, -1, 5, -1, -1, -1, -1, 9}};
	
	public static void main(String[] args) {
		System.out.println("Game board looks legit? " + gameBoardVerified());
		if(solveSudoku()) {
			printBoard();
		} else {
			System.out.println("No solution found :(");
		}
		
	}
	
	private static void printBoard() {
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				if(j == 2 || j == 5)
					System.out.print(gameBoard[i][j] + "|");
				else
					System.out.print(gameBoard[i][j] + " ");
				
			}
			if(i == 2 || i == 5)
				System.out.println("\n------------------");
			else
				System.out.println();
		}
	}
	
	private static boolean solveSudoku() {
		Coord c = findNextEmptySquare();
		if(c == null) {
			return true; //we must have filled everything in. 
		} else {
			//System.out.println("Next empty square: " + c.getX() + "," + c.getY());
			for(int i = 1; i <= 9; ++i) {
				if(isSafe(i, c.getX(), c.getY())) {
					gameBoard[c.getX()][c.getY()] = i;
					if(solveSudoku())
						return true;
					
					gameBoard[c.getX()][c.getY()] = -1;
				}
			}
		}
		
		return false;
	}
	
	private static Coord findNextEmptySquare() {
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				if(gameBoard[i][j] == -1)
					return new Coord(i, j);
			}
		}
		
		return null;
	}
	
	private static boolean gameBoardVerified() {
		if(!is9x9()) {
			return false;
		}
		
		for(int k = 0; k < 9; ++k) {
			for(int j = 0; j < 9; ++j) {
				if(gameBoard[k][j] != -1) {
					if(!isValid(gameBoard[k][j], k, j)) {
						//System.out.println("Invalid: " + gameBoard[k][j] + ":" + k + "," + j);
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private static boolean isSafe(int value, int x, int y) {
		return isSafeWithinBox(value, x - x%3, y - y%3) && isSafeForColumn(value, y) && isSafeForRow(value, x);
	}
	
	private static boolean isSafeWithinBox(int value, int x, int y) {
		//System.out.println("swb:" + x + "," + y);
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(gameBoard[x + i][y + j] == value)
					return false;
			}
		}
		
		return true;
	}
	
	private static boolean isSafeForColumn(int value, int colNum) {
		for(int i = 0; i < 9; ++i) {
			if(gameBoard[i][colNum] == value) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isSafeForRow(int value, int rowNum) {
		for(int i = 0; i < 9; ++i) {
			if(gameBoard[rowNum][i] == value) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isValid(int value, int x, int y) {
		return isValidWithinBox(value, x - x%3, y - y%3) && isValidForColumn(value, y) && isValidForRow(value, x);
	}
	
	private static boolean isValidWithinBox(int value, int x, int y) {
		boolean seen = false;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(gameBoard[x + i][y + j] == value)
					if(!seen)
						seen = true;
					else
						return false;
			}
		}
		
		return true;
	}
	
	private static boolean isValidForColumn(int value, int colNum) {
		boolean seen = false;
		for(int i = 0; i < 9; ++i) {
			if(gameBoard[i][colNum] == value) {
				if(!seen)
					seen = true;
				else
					return false;
			}
		}
		
		return true;
	}
	
	private static boolean isValidForRow(int value, int rowNum) {
		boolean seen = false;
		for(int i = 0; i < 9; ++i) {
			if(gameBoard[rowNum][i] == value) {
				if(!seen)
					seen = true;
				else
					return false;
			}
		}
		
		return true;
	}
	
	private static boolean is9x9() {
		if(gameBoard.length != 9) {
			return false;
		}
		for(int i = 0; i < gameBoard.length; ++i) {
			int width = 0;
			for(int j = 0; j < gameBoard[i].length; ++j) {
				width +=1;
			}
			if(width != 9) {
				System.out.println(i + "," + width);
				return false;
			}
		}
		
		return true;
	}
}

class Coord {
	private int x;
	private int y;
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}