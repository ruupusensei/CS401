
public class GraphTest {
	
	public static void main(String [] args){
	
		MyGraph<Integer, Integer> myGraph = new MyGraph<Integer, Integer>();
		
		System.out.println(myGraph);
		myGraph.addVertex(1,10); // label 1 payload 10
		System.out.println(myGraph);
		myGraph.addVertex(5,3);
		myGraph.addVertex(5,1); // duplicate label - should be ignored
		myGraph.addVertex(2,1);
		myGraph.addVertex(3,4);
		myGraph.addVertex(8,4);
		myGraph.addVertex(4,100);
		System.out.println(myGraph);
		myGraph.addEdge(2,5);
		System.out.println(myGraph);
		myGraph.addEdge(2,5); // duplicate edge - should be ignored
		myGraph.addEdge(2,1);
		myGraph.addEdge(8,5);
		myGraph.addEdge(1,8);
		myGraph.addEdge(1,3);
		myGraph.addEdge(1,4);
		System.out.println(myGraph);
		
		System.out.println("BFS");
		myGraph.breadthFirstTraversal(5);
		System.out.println("DFS");
		myGraph.depthFirstTraversal(5);
		
	}
}
