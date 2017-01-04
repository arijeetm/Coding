package Google;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		ListNode root = new ListNode(0);
		ListNode curr= root;
		PriorityQueue<ListNode> q= new PriorityQueue<>(lists.length, new Comparator<ListNode>(){

			@Override
			public int compare(ListNode p1, ListNode p2) {
				return p1.val-p2.val;
			}
			
		});
		for(ListNode node: lists){
			if(node!=null) q.add(node); //push start or each list
		}
		while(!q.isEmpty()){
			curr.next = q.poll();
			curr= curr.next;
			if(curr.next!=null) q.add(curr.next);
		}
		return root.next;
	}
}
