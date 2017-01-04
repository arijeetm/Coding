package Google;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicateLetters("bcabc"));
	}

	public static String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0)
			return s;
		int freq[] = buildFrequencyChar(s); // frequency table
		boolean taken[] = new boolean[26]; // track characters taken into result
		StringBuilder res = new StringBuilder();
		for (Character ch : s.toCharArray()) {
			int i = ch - 'a';
			if (!taken[i]) {
				while (res.length() > 0 && 
						res.charAt(res.length()-1) > ch && 
						freq[res.charAt(res.length()-1) - 'a'] > 0) { // remove
					taken[res.charAt(res.length()-1) - 'a'] = false;
					res.deleteCharAt(res.length() - 1);
					
				}

				taken[i] = true; // mark
				res.append(ch); // take
			}
			freq[i]--; // for all
		}
		return res.toString();
	}

	private static int[] buildFrequencyChar(String s) {
		int freq[] = new int[26];
		for (Character ch : s.toCharArray())
			freq[ch - 'a']++;
		return freq;
	}
}
