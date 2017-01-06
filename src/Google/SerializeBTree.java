package Google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}

public class SerializeBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node= new TreeNode(1);
		node.left= new TreeNode(2);
		String data = serialize(node);
		System.out.println(data);
		node = deserialize(data);
		System.out.println(node);
	}
	 // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder res= new StringBuilder();
        buildString(root, res);
        res.deleteCharAt(res.lastIndexOf(","));
        return res.toString();
    }

    private static void buildString(TreeNode root, StringBuilder res) {
		if(root==null) {
			res.append("XX");
			res.append(",");
			return;
		}
		res.append(root.val).append(",");
		buildString(root.left, res);
		buildString(root.right, res);
	}
    
	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if(data==null || data.isEmpty()) return null;
        TreeNode root=null;
        Deque<String> s= new ArrayDeque<String>();
        s.addAll(Arrays.asList(data.split(",")));
        return buildTree(root, s);
    }
    
	private static TreeNode buildTree(TreeNode root, Deque<String> data) {
		if(data.peek().equals("XX")) {
			data.remove();
			return null;
		}
		root= new TreeNode(Integer.parseInt(data.remove()));
		root.left= buildTree(root.left, data);
		root.right= buildTree(root.right, data);
		return root;
	}
}
