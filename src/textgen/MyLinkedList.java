package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element The element to add
	 */
	public boolean add(E element) {
		// TODO: Implement this method
		add(this.size, element);
		return true;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E get(int index) {
		// TODO: Implement this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		LLNode<E> node = this.head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
			if (index == i) {
				break;
			}
		}
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The     index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Invalid index");
		if (element == null)
			throw new NullPointerException("Parameter Type cannot be null");
		if (index == size) {
			LLNode<E> temp = new LLNode<E>(element);
			temp.prev = this.tail.prev;
			temp.next = tail;
			this.tail.prev.next = temp;
			this.tail.prev = temp;
			size++;
			return;
		}
		LLNode<E> node = this.head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
			if (index == i) {
				LLNode<E> temp = new LLNode<E>(element);
				temp.prev = node.prev;
				temp.next = node.prev.next;
				node.prev.next = temp;
				node.prev = temp;
				size++;
			}
		}
	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		LLNode<E> node = this.head;
		E data = null;

		for (int i = 0; i <= index; i++) {
			node = node.next;
			if (index == i) {
				data = node.data;
				node.prev.next = node.next;
				node.next.prev = node.prev;
				this.size--;
			}
		}
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index   The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if (element == null)
			throw new NullPointerException("Invalid index");

		LLNode<E> node = this.head;
		E data = null;
		for (int i = 0; i <= index; i++) {
			node = node.next;
			if (index == i) {
				data = node.data;
				node.data = element;
			}
		}
		return data;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
