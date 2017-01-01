package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
 
class IntervalNode{
	Interval i; 
	IntervalNode left, right;
}
public class IntervalTree {

	public static void main(String[] args) {
		System.out.println(insert(
				Arrays.asList(), newInterval(5,7)));

	}
	
	public static Interval newInterval(int low, int high){
		Interval i= new Interval();
		i.start=low; i.end=high;
		return i;
	}
	
	public static IntervalNode newNode(Interval i){
		IntervalNode node = new IntervalNode();
		node.i = i;
		node.left=null;
		node.right=null;
		//node.max=i.high;
		return node;
	}
	
	public static IntervalNode insertToTree(IntervalNode root, Interval i){
		if (root==null) // new tree 
			return newNode(i);
		if(i.end < root.i.start){
			root.left= insertToTree(root.left, i);
		} else if(i.start > root.i.end){
			root.right=insertToTree(root.right, i);
		} else { //Overlap
			int low= Math.min(root.i.start, i.start);
			int high= Math.max(root.i.end, i.end);
			root.i= newInterval(low, high);
			return root;
		}
		return root;
	}
	
	private static void traverse(IntervalNode node, List<Interval> res){
		if(node==null) return;
		traverse(node.left, res);
		res.add(node.i);
		traverse(node.right, res);
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //create interval tree
		IntervalNode root= null;
		for(Interval i: intervals) {
			root= insertToTree(root, i);
		}
		root= insertToTree(root, newInterval);
		//traverse
		List<Interval> res= new ArrayList();
		traverse(root, res);
		return res;
    }

}
