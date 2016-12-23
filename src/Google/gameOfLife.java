package Google;

public class gameOfLife {

	public static void main(String[] args) {
		int board[][] = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
		gameOfLife(board);
	}
	public static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int newboard[][] = new int[m][n];
		int x[] ={-1,-1,-1, 0, 0, 1,1,1};
		int y[] ={-1, 0, 1,-1, 1,-1,0,1};
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		 	int count=0;
	        		for(int l=0; l<8; l++){
	        			if (isValidMove(i+x[l],j+y[l],m,n) &&  board[i+x[l]][j+y[l]]==1) {
	        				//if(count==-1) count=0;
	        				count++;
	        			}
	        		}
	        		newboard[i][j]=board[i][j];
	        		if(board[i][j]==1 && (count<2 || count>3)) 
	        			newboard[i][j]=0; //dead
	        		else if(board[i][j]==0 && count==3) 
	        			newboard[i][j]=1; // reproduce
        	}
        }
        printboard(newboard, m, n);
    }
	
	private static void printboard(int[][] board, int m, int n) {
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++)
				System.out.println(board[i][j]);
		}
	}
	
	public static boolean isValidMove(int r, int c, int m, int n){
		if(r<0 || c<0 || r>=m || c>=n) 
			return false;
		return true;
	}
}
