public class Node<T> {
	protected T payload;
	protected Node<T> next;

	/**
	* Non-parameterized constructor
	*/
	public Node(){
		this.payload = null;
		this.next = null;
	}

	/**
	* Parameterized constructor
	* @param initialPayload
	* @param nextNode
	*/
	public Node(T initialPayload, Node<T> nextNode){
		this.payload = initialPayload;
		this.next = nextNode;
	}

	/**
	* Getter method for the payload attribute
	*
	*/
	public T getPayload(){
		return this.payload;
	}

	/**
	* Getter method for the next attribute
	*
	*/
	public Node<T> getNext(){
		return this.next;
	}

	/**
	* Setter method for the payload attribute
	*
	* @param newPayload
	*/
	public void setPayload(T newPayload){
		this.payload = newPayload;
	}

	/**
	* Setter method for the next attribute
	*
	* @param newNext
	*/
	public void setNext(Node<T> newNext){
		this.next = newNext;
	}

	/**
	* Returns a String containing the attritube information for the Node. 
	*
	*/
	@Override
	public String toString(){
		return "Payload: " + this.payload + " | next: (" + this.next + ")";
	}
}
