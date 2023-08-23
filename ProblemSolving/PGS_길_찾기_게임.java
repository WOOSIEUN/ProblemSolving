import java.util.*;
public class PGS_길_찾기_게임 {
	
	class Solution {
		class Node implements Comparable<Node> {
	        int idx, x, y;
	        Node rightChild, leftChild;
	        public Node(int idx, int x, int y, Node rightChild, Node leftChild) {
	            this.idx = idx;
	            this.x = x;
	            this.y = y;
	            this.rightChild = rightChild;
	            this.leftChild = leftChild;
	        }
	        
	        @Override
	        public int compareTo(Node node) {
	            if (this.y == node.y) {
	                return this.x - node.x;
	            }
	            return node.y - this.y;
	        }
	    }
	     
	    int[][] answer;
	    int idx;
	    
	    public int[][] solution(int[][] nodeinfo) {
	        answer = new int [2][nodeinfo.length];
	        ArrayList<Node> nodeList = new ArrayList<> ();
	        for (int i = 0; i < nodeinfo.length; i++) {
	            nodeList.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null));
	        }
	        Collections.sort(nodeList);
	        
	        Node root = nodeList.get(0);
	        for (int i = 1; i < nodeList.size(); i++) {
	            makeTree(root, nodeList.get(i));
	        }
	        
	        idx = 0;
	        preOrder(root);
	        idx = 0;
	        postOrder(root);
	        
	        return answer;
	    }
	    
	    private void preOrder(Node cur) {
	        if (cur == null) {
	            return;
	        }
	        answer[0][idx++] = cur.idx;
	        preOrder(cur.leftChild);
	        preOrder(cur.rightChild);
	    }
	    
	    private void postOrder(Node cur) {
	        if (cur == null) {
	            return;
	        }
	        postOrder(cur.leftChild);
	        postOrder(cur.rightChild);        
	        answer[1][idx++] = cur.idx;
	    }
	    
	    private void makeTree(Node cur, Node next) {
	        if (cur.x > next.x) {
	            if (cur.leftChild == null) {
	                cur.leftChild = next;
	            } else {
	                makeTree(cur.leftChild, next);
	            }
	        } else {
	            if (cur.rightChild == null) {
	                cur.rightChild = next;
	            } else {
	                makeTree(cur.rightChild, next);
	            }
	        }
	    }
	}
}