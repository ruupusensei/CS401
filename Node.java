public class Node<T> {
	protected T payload;
	protected Node<T> next;
	
	public Node(){
		this.payload = null;
		this.next = null;
	}
	
	public Node(T initialPayload, Node<T> nextNode){
		this.payload = initialPayload;
		this.next = nextNode;		
	}
	
	public T getPayload(){
		return this.payload;
	}
	
	public Node<T> getNext(){
		return this.next;
	}
	
	public void setPayload(T newPayload){
		this.payload = newPayload;
	}
	
	public void setNext(Node<T> newNext){
		this.next = newNext;
	}
	
	public String toString(){
		return "Payload: " + this.payload + " | next: (" + this.next + ")";
	}
}