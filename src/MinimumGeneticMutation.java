import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minMutation(String start, String end, String[] bank) {
		if(start==null || start.length()==0 || start.length()!=end.length()) return -1;
		if(start.equals(end)) return 0;
		int len= start.length();
		Set<String> bankset= new HashSet<>(bank.length);
		for(int i=0; i<bank.length; i++) bankset.add(bank[i]);
		char mutation[]= {'A','C','G','T'};
		Queue<String> q= new LinkedList<>();
		Set<String> vis= new HashSet<>();
		q.add(start);
		int level=0;
		while(!q.isEmpty()){
			int size= q.size();
			while(size-->0){
				String gene= q.poll();
				if(gene.equals(end)) return level;
				char[] garr= gene.toCharArray();
				for(int i=0; i<len; i++){
					char backup= garr[i];
					for(int j=0; j<4; j++){
						garr[i]= mutation[j]; //change one only
						String newgene= new String(garr);
						if(bankset.contains(newgene) && !vis.contains(newgene)){
							q.add(newgene);
							vis.add(newgene);
						}
						garr[i]= backup;
					}
				}
			}
			level++;
		}
		return -1;
	}
}
