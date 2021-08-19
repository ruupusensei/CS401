/**
* 
* A generics List interface
* 
* @author	Jacek Dzikowski
* @version	1.00.00
*/
 
public interface MyListInterface<E> {
	
	/**
	* Appends the specified element to the end (tail) of this List.
	*
	* @param	element		new element
	*/
	public void add(E element);
	
	/**
	* Inserts the specified element at the specified position index in this List.
	*
	* @param	index		new element index
	* @param	element		new element
	*/
	public void add(int index, E element);
	
	/**
	* Appends the specified element to the front of this List.
	*
	* @param	element		new element
	*/
	public void addFront(E element);
	
	/**
	* Returns the element at the specified position (index) in this List. 
	*
	* @param	index		index of the element to be returned
	* @return	E			element at position index. null if index >= size
	*/
	public E get(int index);

	/**
	* Returns the first element in this List. 
	*
	* @param	index		index of the element to be returned
	* @return	E			element at position index. null if List is empty
	*/
	public E getFront();
	
	/**
	* Returns the last element in this List. 
	*
	* @param	index		index of the element to be returned
	* @return	E			element at position index. null if List is empty
	*/
	public E getTail();
	
	/**
	* Returns the index in this List of the first occurrence of the specified key, or -1 if List does not contain this key.
	*
	* @param	key			specified key to be found in List
	* @return	E			index of the specified key in List or -1 if not found
	*/
	public int indexOf(E key);
	
	/**
	* Removes the element at the specified position in this List.
	*
	* @param	index		index of the element to be removed
	*/	
	public void remove(int index);
	
	/**
	* Removes the last element of the List. 
	*
	*/	
	public void removeTail();

	/**
	* Returns the number of elements in this List.
	*
	* @return	int			number of elements in List
	*/
	public int size();
	
	/**
	* Lists/displays all elements in this List.
	*
	*/
	public void listAll();
}