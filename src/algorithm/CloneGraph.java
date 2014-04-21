package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class CloneGraph {

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        Map<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode firstNode = new UndirectedGraphNode(node.label);
        map.put(firstNode.label,firstNode);
        queue.offer(node);
        
        while(queue.peek()!=null){
            UndirectedGraphNode oldNode = queue.poll();
            UndirectedGraphNode newNode = map.get(oldNode.label);
            for(int i=0;i<oldNode.neighbors.size();i++){
                UndirectedGraphNode oldNeighbor = oldNode.neighbors.get(i);
                UndirectedGraphNode newNeighbor = map.get(oldNeighbor.label);
                if(newNeighbor == null){
                    newNeighbor = new UndirectedGraphNode(oldNeighbor.label);
                    map.put(newNeighbor.label,newNeighbor);
                    queue.offer(oldNeighbor);
                }
                newNode.neighbors.add(newNeighbor);
            }
        }
        return firstNode;
    }

	public static void main(String[] args){
		UndirectedGraphNode zero = new UndirectedGraphNode(0);
		UndirectedGraphNode one = new UndirectedGraphNode(1);
		UndirectedGraphNode two = new UndirectedGraphNode(2);
		one.neighbors.add(two);
		zero.neighbors.add(one);
		two.neighbors.add(two);
		
		UndirectedGraphNode newNode = cloneGraph(zero);
		System.out.println(newNode);
	}
	
}
