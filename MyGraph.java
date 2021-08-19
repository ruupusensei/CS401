import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class MyGraph<K extends Comparable<K>,T> {

	protected MySinglyLinkedList<MyVertex<K,T>> vertices;

	public MyGraph(){
		this.vertices = new MySinglyLinkedList<MyVertex<K,T>>();
	}

	/**
	* Adds a vertex to the Graph by taking a label and payload argument; those
	* arguments cannot be null. Will not add duplicate labels.
	*
	* @param newLabel 	label for the new vertex
	* @param newPayload	payload for the new vertex
	*
	* return boolean True if successfully added, false otherwise
	*/
	public boolean addVertex(K newLabel, T newPayload){

		// newLabel and newPayload cannot be null
		if( newLabel == null || newPayload == null) {
			return false;
		}
		// no duplicates in vertices list allowed (duplicate -> same label)
		Stack<K> s = new Stack<K>();
		int i = 0;
		while (i < this.getVertices().size()) { //add all elements in vertices list to stack
			s.add(this.getVertices().get(i).getLabel());
			i++;
		}

		while (s.isEmpty() == false) {
			if ( s.peek().compareTo(newLabel) ==  0) { //check for duplicate labels in stack
				return false; // if duplicate exists, don't add
			}
			s.pop();
		}
		// adding a vertex  means adding a new vertex object to the vertices list
		// returns true if success | false if failure

		this.vertices.add(new MyVertex<K,T>(newLabel, newPayload));
		return true;
	}

	/**
	* Adds an edge to the graph between 2 existing vertices in the graph.
	* Takes 2 vertex lables as arguments to construct the edge.
	* Does not allow null arguments or duplicate edges.
	*
	* @param startPointLabel 	vertex label
	* @param endPointLabel	vertex label
	*
	* return boolean True if successfully added, false otherwise
	*/
	public boolean addEdge(K startPointLabel, K endPointLabel){

		// startPointLabel and endPointLabel cannot be null
		// startPointLabel and endPointLabel cannot be equal
		if ( startPointLabel == null || endPointLabel == null ||
				startPointLabel.compareTo(endPointLabel) == 0) {
			return false;
		}

		// if either startPointLabel or endPointLabel  is NOT present in vertices, no add!

		else if (this.getVertices().size() < 2) { // not enough vertices to add an edge
			return false;
		}

		else {

			boolean startPresent = false;
			boolean endPresent = false;

			Stack<K> s = new Stack<K>();
			int i = 0;
			while (i < this.getVertices().size()) { //add all labels of vertices in vertices list to stack
				s.add(this.getVertices().get(i).getLabel());
				i++;
			}

			while (s.isEmpty() == false) {
				if ( s.peek().compareTo(startPointLabel) == 0) {
					startPresent = true; //mark true if start label exists in the stack
				}

				if(s.peek().compareTo(endPointLabel) == 0 ) {
					endPresent = true; //mark true if end label exists in the stack
				}
				s.pop();
			}

			if (startPresent == false || endPresent == false) {
				return false; //return false if either start or end label isn't found
			}

		// no duplicate edges allowed
		// duplicate edge means one label exists in the other labels adjacency list
		// if endPointLabel exists in startPointLabel's adjacency list, return false (do not add)

			Stack<MyVertex<K,T>> s1 = new Stack<MyVertex<K,T>>();
			int j = 0;
			while (j < this.getVertices().size()) { //add all objects in vertices list to stack
				s1.add(this.getVertices().get(j));
				j++;
			}
			MySinglyLinkedList<K> tempStartList = null;
			MyVertex<K,T> startVertex = null; //
			MyVertex<K,T> endVertex = null;

			while (s1.isEmpty() == false) {
				if (s1.peek().getLabel().compareTo(startPointLabel) == 0) { // will be true once since we know both start and end exist
					tempStartList = s1.peek().getAdjacencyList(); //tempStartList is now equal to startPointLabel's adjacency list
					startVertex = s1.peek(); //grab vertex object for startPoint
				}
				if (s1.peek().getLabel().compareTo(endPointLabel) == 0) {
					endVertex = s1.peek(); //grab vertex object for endPoint
				}
				s1.pop();
			}

			if (tempStartList.size() > 0) {

				Stack<K> s2 = new Stack<K>();
				int k = 0;
				while (k < tempStartList.size()) { //add all labels of vertices in startLabel's adjacency list to stack
					s2.add(tempStartList.get(k));
					k++;
				}

		//if endLabel already exists in startLabel's adjacency list, return false
				while (s2.isEmpty() == false) {
					if(s2.pop().compareTo(endPointLabel) == 0) { // endPointLabel already exists in startPointLabel's
						return false;							// adjacency list, return false (edge would be duplicate)
					}
				}
		//at this point startLabel and endLabel are not null, they are not equal, and an edge between them does not exist
		// adding an edge means updating adjacency lists for vertices with startPointLabel and endPointLabel accordingly
		//use addEdge method from MyVertex to add edges
				startVertex.addEdge(endPointLabel);
				endVertex.addEdge(startPointLabel);
				return true;
		}

			else { // adjacency list of startPoint is empty
				startVertex.addEdge(endPointLabel);
				endVertex.addEdge(startPointLabel);
				return true;
			}
		}
	}

	/**
	* Private getter method to return the linked list containing all
	* the vertices in the graph. Used for graph traversals.
	*
	*/
	private MySinglyLinkedList<MyVertex<K,T>> getVertices(){
		return this.vertices;
	}

	/**
	* Override function to return a list of all the vertices within the graph.
	*
	* return String
	*/
	@Override
	public String toString(){

		String string = "";

		if( this.getVertices().size() == 0) {
			string = "Empty Graph";
			return string;
		}

		else {
		Stack<MyVertex<K,T>> s = new Stack<MyVertex<K,T>>();
		int i = 0;
		while (i < this.getVertices().size()) { //add all objects in vertices list to stack
			s.add(this.getVertices().get(i));
			i++;
		}

		while (s.isEmpty() == false) {
			string = string.concat( s.peek() + "\n");
			s.pop();
		}

		return string;
		}
	}

	/**
	* Takes a source vertex as an argument and performs a depth first traversal
	* of the graph.
	*
	* @param label 	source vertex for the DFT
	*/
	public void depthFirstTraversal(K label) {
		//set up necessary structures
		Stack<MyVertex<K,T>> s = new Stack<MyVertex<K,T>>();
		Set<K> visited = new HashSet<K>();
		MyVertex<K,T> firstVertex = new MyVertex<K,T>(null, null);

		//next, find the first vertex based on the label

		for( int i = 0; i < this.getVertices().size(); i++) {
			if(this.getVertices().get(i).getLabel().compareTo(label) == 0) {
				firstVertex = this.getVertices().get(i);
				break;
			}
		}
		//push firstVertext to the stack, mark it as visited
		s.push(firstVertex);
		visited.add(firstVertex.getLabel());

		//while the stack is not empty, traverse
		while(s.isEmpty() == false) {
			MyVertex<K,T> current = s.pop();
			System.out.println(current);

			for (int i = 0; i < current.getAdjacencyList().size(); i++) {
				if( visited.contains(current.getAdjacencyList().get(i)) == false ) {
					//the vertex is not yet visited, get it and push it onto the stack
					for (int j = 0; j < this.getVertices().size(); j++) {
						if(this.getVertices().get(j).getLabel().compareTo(current.getAdjacencyList().get(i)) == 0 ) {
							MyVertex<K,T> next = this.getVertices().get(j);
							s.push(next);
							visited.add(next.getLabel());
						}
					}
				}
			}
		}
	}

	/**
	* Takes a source vertex as an argument and performs a breadth first traversal
	* of the graph.
	*
	* @param label 	source vertex for the BFT
	*/
	public void breadthFirstTraversal(K label) {
		// set up necessary structures
		Queue<MyVertex<K,T>> q = new LinkedList<MyVertex<K,T>>();
		Set<K> visited = new HashSet<K>();
		MyVertex<K,T> firstVertex = new MyVertex<K,T>(null, null);

		//find the firstVertex based on given label
		for( int i = 0; i < this.getVertices().size(); i++) {
			if(this.getVertices().get(i).getLabel().compareTo(label) == 0) {
				firstVertex = this.getVertices().get(i);
				break;
			}
		}

		//add the first vertex to the queue and mark it as visited
		q.add(firstVertex);
		visited.add(firstVertex.getLabel());

		//while the queue is not empty, traverse
		while(q.isEmpty() == false) {
			MyVertex<K,T> current = q.remove();
			System.out.println(current);

			for (int i = 0; i < current.getAdjacencyList().size(); i++) {
				if( visited.contains(current.getAdjacencyList().get(i)) == false ) {
					//the vertex is not yet visited, get it and add it to the queue
					for (int j = 0; j < this.getVertices().size(); j++) {
						if(this.getVertices().get(j).getLabel().compareTo(current.getAdjacencyList().get(i)) == 0 ) {
							MyVertex<K,T> next = this.getVertices().get(j);
							q.add(next);
							visited.add(next.getLabel());
						}
					}
				}
			}
		}
	}

}
