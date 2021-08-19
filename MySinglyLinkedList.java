public class MySinglyLinkedList<E> implements MyListInterface<E> {
	protected Node<E> head;
	private Node <E> prev;
	private int size = 0;
	
	public MySinglyLinkedList(){
		this.head = null;
	}
	
	/**
	* Appends the specified element to the end (tail) of this List.
	*
	* @param	element		new element
	*/
	public void add(E element) {
		
		Node <E> current = this.head;
		
		if (current == null) {
			this.head = new Node<E>(element, null);
			this.size++;
		}
		
		else if (current.getNext() == null) {
			current.next = new Node<E>(element, null);
			this.size++;
		}
	
		else {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.next = new Node<E>(element, null);
			this.size++;
		}
		
	}
	
	/**
	* Inserts the specified element at the specified position index in this List.
	*
	* @param	index		new element index
	* @param	element		new element
	*/
	public void add(int index, E element) {
		
		if (index >= this.size() || index < 0) {
			return;
		}
		
		else if (index == 0) {
			Node <E> newNode = new Node<E>(element, this.head);
			this.head = newNode;
			this.size++;
		}
		
		else {	
			Node<E> current = this.head;
			this.prev = null;	
			int count = 0;
			
			while (count < index) {
				this.prev = current;
				current = current.getNext();
				count++;
			}
			
			Node<E> newNode = new Node<E>(element, current);
			this.prev.setNext(newNode);	
			this.size++;
		}
	}
	
	/**
	* Appends the specified element to the front of this List.
	*
	* @param	element		new element
	*/
	public void addFront(E element) {
		
		Node <E> current = this.head;
			
		if (current == null) {
			this.head = new Node<E>(element, null);
			this.size++;
		}
		
		else {
			Node <E> newHead = new Node<E>(element, this.head);
			this.head = newHead;	
			this.size++;
		}
	}
	
	/**
	* Returns the element at the specified position (index) in this List. 
	*
	* @param	index		index of the element to be returned
	* @return	int			element at position index. null if index >= size
	*/
	public E get(int index) {
		
		Node <E> current = this.head;
		int count = 0;

		if (index >= this.size() || index < 0) {
			return null;
		}
		else {
			while (count < index) {
				current = current.getNext();
				count++;
			}
		return current.getPayload();
		}
	}

	/**
	* Returns the first element in this List. 
	*
	* @param	index		index of the element to be returned
	* @return	int			element at position index. null if List is empty
	*/
	public E getFront() {
		
		Node <E> current = this.head;
		
		if (current == null) {
			return null;
		}
		else {
			return this.head.getPayload();
		}
		
	}
	
	/**
	* Returns the last element in this List. 
	*
	* @param	index		index of the element to be returned
	* @return	int			element at position index. null if List is empty
	*/
	public E getTail() {
	
		Node <E> current = this.head;
		
		if (current == null) {
			return null;
		}
	
		else {
		
		while ( current.getNext() != null) {
			current = current.getNext();
		}
		return current.getPayload();	
		}
	}
	
	/**
	* Returns the index in this List of the first occurrence of the specified key, or -1 if List does not contain this key.
	*
	* @param	key			specified key to be found in List
	* @return	int			index of the specified key in List or -1 if not found
	*/
	public int indexOf(E key) { //fails for index = 0 case
		
		Node <E> current = this.head;
		int index = 0;
		
		if (current ==null) {
			return -1;
		}
		
		
		else if (current.getPayload() == key) {
			return index;
		}

		
		else {
			while (current.getNext() != null) {
				current = current.getNext();
				index++;
				if (current.getPayload() == key) {
					return index;
				}
			}
			return -1;
		}
	}
	
	/**
	* Removes the element at the specified position in this List.
	*
	* @param	index		index of the element to be removed
	*/	
	public void remove(int index) {
	
		if (index >= this.size() || index < 0) {
			return;
		}
		
		else if (index == 0) {
			this.head = this.head.getNext();
			this.size--;
		}
		
		else {
			int count = 0;
			this.prev = null;
			Node <E> current = this.head;
			while (count < index) {
				this.prev = current;
				current = current.getNext();
				count++;
			}//after running, current is the node i want to delete. so previous needs to connect to current's next. 
			
			this.prev.setNext(current.getNext());
			current.setNext(null);
			this.size--;
		}
	}
	
	/**
	* Removes the last element of the List. 
	*
	*/	
	public void removeTail() {
		
		Node <E> current = this.head;
		prev = null;
		
		if (current == null) {
			return;
		}
		
		else if (current.getNext() == null) {
			this.head = null;
			this.size--;
		}
	
		else {
			while (current.getNext() != null) {
				prev = current;
				current = current.getNext();
			} // after this loop current is the tail, prev is node before tail

			prev.setNext(null); 
			this.size--;
		}
	}

	/**
	* Returns the number of elements in this List.
	*
	* @return	int			number of elements in List
	*/
	public int size() {
		return this.size;
	}
	
	/**
	* Lists/displays all elements in this List.
	*
	*/
	public void listAll(){
		//null "This list is empty"
		//Element at Node 0: 100
		
		Node <E> current = this.head;
		
		if (current == null) {
			System.out.println("This list is empty");
		}
		
		else {
			int index = 0;
			while (current.getNext() != null) {	
				System.out.println("Element at Node " + index + ": " + current.getPayload() );
				current = current.getNext();
				index++;
			}
			System.out.println("Element at Node " + index + ": " + current.getPayload() );
		}	
	}
}