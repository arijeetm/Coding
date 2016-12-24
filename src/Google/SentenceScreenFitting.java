package Google;

public class SentenceScreenFitting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordsTyping(new String[]{
				//"hello", "world"},2,8));
				//"a", "bcd", "e"}, 3, 6));
				"I", "had", "apple", "pie"},  4, 5));
	}

	public static int wordsTyping(String[] sentence, int rows, int cols) {
		int sindx=0, count=0, n=sentence.length;
		for(int i=0; i<rows ; i++){
			int currlen = 0;
			while(currlen + sentence[sindx].length() <= cols){
				currlen += sentence[sindx++].length()+1;
				if(sindx==n) {
					count++;
					sindx = 0;
				}
			}
		}
		return count;
	}
}
