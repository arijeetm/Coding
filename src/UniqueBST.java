import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(2));
	}
	public List<TreeNode> generateTrees(int n) {
		if(n==0) return new ArrayList<>();
		List<TreeNode>[] dp= new List[n];
		dp[0] = new ArrayList<>(); dp[0].add(null);
		dp[1] = new ArrayList<>(); dp[1].add(new TreeNode(1));
		if(n==1) return dp[1];
		for(int len=2; len<=n; len++){
			dp[len]= new ArrayList<TreeNode>();
			for(int root=1; root<=len; root++){
				for(TreeNode nodel: dp[root-1]){
					for(TreeNode noder: dp[len-root]){
						TreeNode node= new TreeNode(root);
						node.left= nodel;
						node.right= setTree(noder, root+1);
						dp[len].add(node);
					}
				}
			}
		}
		return dp[n];
	}
	
	private static TreeNode setTree(TreeNode node, int offset){
		if(node==null) return null;
		TreeNode curr = new TreeNode(node.val + offset);
		curr.left= setTree(node.left, offset);
		curr.right= setTree(node.right, offset);
		return curr;
	}
	
	//number of ways to represent 1..n in BST
	public static int numTrees(int n) {
		if(n==0 || n==1) return 1;
		int dp[]= new int[n+1];
		dp[0]=1; dp[1]=1;
		for(int i=2; i<=n ;i++){
			for(int j=1; j<=i; j++){
				dp[i] += dp[j-1]* dp[i-j]; //sum of all possibilities with root j
			}
		}
		return dp[n];
	}
}
