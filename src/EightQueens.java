import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EightQueens {
	
	static int SIZE=8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> ans = new ArrayList<>();
		placeQueens(0, Arrays.asList(new Integer[SIZE]), ans);
		System.out.println(ans);
	}
	public static void placeQueens(int row, List<Integer> res, List<List<Integer>> result){
		if(row==SIZE) {
			result.add(new ArrayList<>(res)); 
			// Carefull!! we need to add a copy of res to result to avoid overriding through reference
			return;
		}
		for(int column=0; column<SIZE; column++){
			if(isValid(row, column, res)) {
				res.set(row, column);
				placeQueens(row+1, res, result);
			}
		}
	}
	
	// Incorrect output
	private static boolean isValid(int row, int column, List<Integer> res) {
		// TODO Auto-generated method stub
		//(row, column) and (r,c) checks
		for(int r=0; r<row; r++){ // row check
			int c = res.get(r);
			if(c==column) return false; //column check
			//diagonal check
			int rowdiff = row-r;
			int coldiff = Math.abs(column-c);
			if(rowdiff==coldiff) return false;
		}
		return true;
	}
}
