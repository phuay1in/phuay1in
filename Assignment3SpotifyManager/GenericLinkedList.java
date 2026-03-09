import java.util.ListIterator;
public class GenericLinkedList<T> implements Iterable<T>{
	private Node firstNode;
	private Node lastNode;
	private int size;
	
	public GenericLinkedList() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node currentNode = firstNode;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}
	
	public T getFirst() {
		if (this.isEmpty())
			throw new IndexOutOfBoundsException();
		return firstNode.data;
	}
	
	public T getLast() {
		if (this.isEmpty())
			throw new IndexOutOfBoundsException();
		return lastNode.data;
	}
	
	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node currentNode = firstNode;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		if (currentNode.prev == null) {
			firstNode = currentNode.next;
			 if (firstNode != null)
		            firstNode.prev = null;
		}
		else if (currentNode.next == null)
			currentNode.prev.next = null;
		else {
			currentNode.prev.next = currentNode.next;
			currentNode.next.prev = currentNode.prev;
		}
		size--;
		return currentNode.data;
	}
	
	public void addFirst(T data) {
		Node newNode = new Node(data);

	    if (isEmpty()) {
	        firstNode = newNode;
	        lastNode = newNode;
	    } else {
	        newNode.next = firstNode;
	        firstNode.prev = newNode;
	        firstNode = newNode;
	    }

	    size++;
	}
	
	public T removeFirst() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		T data = firstNode.data;
		firstNode = firstNode.next;
		
		if (firstNode != null)
	        firstNode.prev = null;
		else
			lastNode = firstNode;
		size--;
		return data;
	}
	
	public void addLast(T data) {
	    Node newNode = new Node(data);

	    if (isEmpty()) {
	        firstNode = newNode;
	        lastNode = newNode;
	    } else {
	        lastNode.next = newNode;
	        newNode.prev = lastNode;
	        lastNode = newNode;
	    }

	    size++;
	}
	
	public T removeLast() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		T data = lastNode.data;
		if (lastNode.prev == null) {
			firstNode = null;
			lastNode = null;
		}
		else {
			lastNode = lastNode.prev;
			lastNode.next = null;
		}
		size--;
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
	    firstNode = null;
	    lastNode = null;
	    size = 0;
	}
	
	public ListIterator<T> iterator() {
		return new GenericIterator();
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean contains(T element) {
	    Node currentNode = firstNode;

	    while (currentNode != null) {
	        if (currentNode.data.equals(element))
	            return true;
	        currentNode = currentNode.next;
	    }

	    return false;
	}
	
	public Object[] toArray() {
	    Object[] array = new Object[size];
	    Node currentNode = firstNode;

	    for (int i = 0; i < size; i++) {
	        array[i] = currentNode.data;
	        currentNode = currentNode.next;
	    }

	    return array;
	}
	
	private class Node {
	    T data;
	    Node next;
	    Node prev;

	    private Node(T data) {
	        this(data, null, null);
	    }
	    
	    private Node(T data, Node nextNode, Node prevNode) {
	    	this.data = data;
	    	next = nextNode;
	    	prev = prevNode;
	    }
	}
	
	private class GenericIterator implements ListIterator<T> {

	    private Node nextNode = firstNode;
	    private Node lastReturned = null;

	    public boolean hasNext() {
	        return nextNode != null;
	    }

	    public T next() {
	        if (!hasNext())
	            throw new java.util.NoSuchElementException();

	        lastReturned = nextNode;
	        nextNode = nextNode.next;
	        return lastReturned.data;
	    }

	    public boolean hasPrevious() {
	        if (nextNode == null)
	            return lastNode != null;
	        return nextNode.prev != null;
	    }

	    public T previous() {
	        if (!hasPrevious())
	            throw new java.util.NoSuchElementException();

	        if (nextNode == null)
	            nextNode = lastNode;
	        else
	            nextNode = nextNode.prev;

	        lastReturned = nextNode;
	        return lastReturned.data;
	    }

	    public void remove() {
	        if (lastReturned == null)
	            throw new IllegalStateException();

	        Node node = lastReturned;

	        if (node.prev == null)
	            firstNode = node.next;
	        else
	            node.prev.next = node.next;

	        if (node.next == null)
	            lastNode = node.prev;
	        else
	            node.next.prev = node.prev;

	        size--;
	        lastReturned = null;
	    }

	    public int nextIndex() { throw new UnsupportedOperationException(); }
	    public int previousIndex() { throw new UnsupportedOperationException(); }
	    public void set(T e) { throw new UnsupportedOperationException(); }
	    public void add(T e) { throw new UnsupportedOperationException(); }
	}
}
