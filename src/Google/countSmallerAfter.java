package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node{
	int val, h, size;
	Node left, right;
}
public class countSmallerAfter {

	private static Node newnode(int value){
		Node root= new Node();
		root.left=null; root.right=null;
		root.val=value;
		root.size=1;
		root.h=0;
		return root;
	}
	private static int getSize(Node root){
		if(root==null) return 0;
		else return root.size;
	}
	private static int getHeight(Node root){
		if(root==null) return 0;
		else return root.h;
	}
	// BST -> O(nlogn)
	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList();
		if(nums==null || nums.length==0) return res;
		int len= nums.length;
		Integer result[]= new Integer[len];
		for(int i=0; i<len; i++) result[i]=0;
		Node root=null;
		for(int i=nums.length-1; i>=0; i--)
			root= insert(nums[i], i, root, result);
		res=Arrays.asList(result);
		return res;
	}
	
	private static Node insert(int v, int indx, Node root, Integer[] result) {
		if(root==null){
			return newnode(v);
		}
		if(v<=root.val) root.left= insert(v, indx, root.left, result);
		else {
			result[indx] += getSize(root.left) +1;
			root.right= insert(v, indx, root.right, result);
		}
		root.size = getSize(root.left) + getSize(root.right) +1;
		root.h= Math.max(getHeight(root.left), getHeight(root.right)) +1;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSmaller(new int[]{5,2,6,1}));
	}

	//simple -> O(n2)
	/*public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList();
		if(nums==null || nums.length==0) return res;
		res.add(0);
		int n=nums.length;
		for(int i=nums.length-2; i>=0; i--){
			int count=0;
			for(int j=i+1; j<n; j++){
				if(nums[i] > nums[j]) count++;
			}
			res.add(0,count);
		}
		return res;
	}*/
}
