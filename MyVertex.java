import java.util.Stack;

public class MyVertex<K extends Comparable<K>,T> {	
// Attribute(s) and constructor(s) go here
	
	protected K label;
	protected T payload;
	protected MySinglyLinkedList<K> adjacencyList;
	protected int degree;
	
	public MyVertex(K label, T payload){
		this.label = label;
		this.payload = payload;
		this.degree = 0;	
		this.adjacencyList = new MySinglyLinkedList<K>();
	}
	
// methods:
	
	public void setLabel(K newLabel){
		this.label = newLabel;
	}
	
	public void setPayload(T newPayload){
		this.payload = newPayload;
	}
	
	public K getLabel(){
		return this.label;
	}
	
	public T getPayload(){
		return this.payload;
	}
	
	public int getDegree(){
		return this.degree;
	}
	
	public MySinglyLinkedList<K>  getAdjacencyList(){
		return this.adjacencyList;
	}
	
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
		// adding an edge means “adding a vertex” with otherLabel to the adjacencyList
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
