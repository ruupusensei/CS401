import java.util.Stack;

public class MyVertex<K extends Comparable<K>,T> {


	protected K label;
	protected T payload;
	protected MySinglyLinkedList<K> adjacencyList;
	protected int degree;

	/**
	* Parameterized constructor for a MyVertex object. Allows user to input
	* the desired label and payload for a vertex.
	*
	* @param label
	* @param payload
	*/
	public MyVertex(K label, T payload){
		this.label = label;
		this.payload = payload;
		this.degree = 0;
		this.adjacencyList = new MySinglyLinkedList<K>();
	}

	/**
	* Setter method for the label attribute
	*
	*/
	public void setLabel(K newLabel){
		this.label = newLabel;
	}

	/**
	* Setter method for the payload attribute
	*
	*/
	public void setPayload(T newPayload){
		this.payload = newPayload;
	}

	/**
	* Getter method for the label attribute
	*
	*/
	public K getLabel(){
		return this.label;
	}

	/**
	* Getter method for the payload attribute
	*
	*/
	public T getPayload(){
		return this.payload;
	}

	/**
	* Getter method for the degree attribute of a vertex.
	* Degree is the number of edges adjacent to any given vertex.
	*
	*/
	public int getDegree(){
		return this.degree;
	}

	/**
	* Getter method for the adjacencyList attribute.
	* Contains a list of all vertices for which an edge exists between them
	* and the current vetex.
	*
	*/
	public MySinglyLinkedList<K>  getAdjacencyList(){
		return this.adjacencyList;
	}

	/**
	* Adds a new vertex to the current vertex's adjacency list, thus a new edge
	* exists in the graph between the 2 vertices.
	*
	* @param otherLabel	The label of the vertex which will be connected to the current
	* vertex by the new edge.
	*/
	public boolean addEdge(K otherLabel){
		// otherLabel cannot be null
		// otherLabel cannot be the same as label
		if ( otherLabel == null || otherLabel.compareTo(this.label) == 0) {
			return false;
		}

		// no duplicates in adjacency list allowed

		if(this.getAdjacencyList() != null) {

		Stack<K> s = new Stack<K>();
		int i = 0;
		while ( i < this.getAdjacencyList().size() ) { //add all elements in adjacency list to stack
			s.add(this.getAdjacencyList().get(i));
			i++;
		}

		while (s.isEmpty() == false) {
			if ( s.peek().compareTo(otherLabel) == 0) { //check for duplicate labels in stack
				return false;
			}
			s.pop();
		}
		// adding an edge means adding a vertex with otherLabel to the adjacencyList
		this.getAdjacencyList().add(otherLabel);
		degree++;
		return true;
		}

		else { // this adjacency list is empty
			this.getAdjacencyList().add(otherLabel);
			degree++;
			return true;
		}

	}

	/**
	* Returns a String containing this vertex object's name, as well as all
	* vertices for which an edge exists between them and the current vertex. 
	*
	*/
	@Override
	public String toString(){

		String string = "[Vertex: " + this.getLabel() + " | " + "adjacent vertices: ";

		if(this.getAdjacencyList().size() == 0) {
			string = string.concat("none]") ;
			return string;
		}

		else {

			Stack<K> s = new Stack<K>();
			int i = 0;
			while ( i < this.getAdjacencyList().size() ) { //add all elements in adjacency list to stack
				s.add(this.getAdjacencyList().get(i));
				i++;
			}

			while (s.isEmpty() == false) {
				string = string.concat(s.pop() + " ") ;
			}

			string = string.concat( "]");
			return string;
		}
	}

}
