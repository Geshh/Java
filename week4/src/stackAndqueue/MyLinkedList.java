package stackAndqueue;

import java.util.Stack;

public class MyLinkedList<T extends Comparable<T>>
		implements MyLinkedListInterface<T>, MyQueueInterface<T>, MyStackInterface<T> {

	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			next = null;
		}
	}

	private Node head;
	private Node lastNode;
	private int size;

	public MyLinkedList() {
		lastNode = null;
		head = null;
		size = 0;
	}

	@Override
	/**
	 * Adds the elements as a first element in the list. Takes O(1) time
	 */
	public void addFirst(T element) {
		if (head != null) {
			Node temp = new Node(element);
			temp.next = head;
			head = temp;

		} else {
			head = new Node(element);
			lastNode = head;
		}
		size += 1;
	}

	@Override
	/**
	 * Adds the provided element to the end of the list Takes O(n) time
	 */
	public void addLast(T element) {
		if (head == null) {
			head = new Node(element);
			lastNode = head;
		} else {
			Node newNode = new Node(element);
			lastNode.next = newNode;
			lastNode = newNode;
		}
		size += 1;
	}

	@Override
	/**
	 * Adds element at index Takes O(n) time
	 */
	public void add(T element, int index) {
		Node temp = head;
		Node newElement = new Node(element);
		if (size > index) {
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			newElement.next = temp.next;
			temp.next = newElement;
			size += 1;
		}
	}

	@Override
	/**
	 * Returns first element in our list Takes O(1) time;
	 */
	public T getFirst() {
		if (head == null) {
			return null;
		}
		return head.data;
	}

	@Override
	/**
	 * Returns last element in our list Takes O(n) time;
	 */
	public T getLast() {
		if (lastNode == null) {
			return null;
		}
		return lastNode.data;
	}

	@Override
	/**
	 * Returns data at index specified Takes O(n) time
	 */
	public T get(int index) {
		Node temp = head;
		if (size > index) {
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			return null;
		}
		return temp.data;
	}

	@Override
	/**
	 * Return length of our Linked List Takes O(1) time
	 */
	public int getSize() {
		return this.size;
	}

	@Override
	/**
	 * Removes Node at index specified Takes O(n) time
	 */
	public void remove(int index) {

		if (size == 0 || index >= size)
			return;
		else if (size == 1) {
			this.head = null;
			this.lastNode = null;
			size -= 1;
		} else if (index == 0) {
			head = head.next;
			size -= 1;
		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			if (index == size - 1) {
				lastNode = temp;
			}
			size -= 1;
		}
	}

	@Override
	/**
	 * Concatenate two lists and return new one Takes O(n) time;
	 */

	public void addList(MyLinkedListInterface<T> other) {
		for (int i = 0; i < other.getSize(); i++) {
			this.addLast(other.get(i));
		}
	}

	public void addListFix(MyLinkedList<T> other) {
		Node temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = other.head;
	}

	private T execute(int index, int curr, Node first, Node following) {
		if (first.next == null) {
			return following.data;
		}
		if (curr >= index) {
			return execute(index, ++curr, first.next, following.next);
		} else {
			return execute(index, ++curr, first.next, following);
		}
	}

	public T getKthElFromBehind(int index) {
		return execute(index, 0, this.head, this.head);
	}

	public T firstElementInLoop() {
		if (hasLoop()) {
			return lastNode.next.data;
		} else {
			return null;
		}
	}

	public Boolean hasLoop() {
		return this.lastNode.next != null;
	}

	@SuppressWarnings("unused")
	private void deleteNode(Node node) {
		if (node == lastNode) {
			remove(size - 1);
		} else {
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}

	public void partitionList(T x) {
		MyLinkedList<T> newList = new MyLinkedList<T>();

		Node temp = head;

		for (int i = 0; i < size; i++) {
			if (temp.data.compareTo(x) < 0) {
				newList.addFirst(temp.data);
			} else {
				newList.addLast(temp.data);
			}
			temp = temp.next;
		}

		this.head = newList.head;
		this.lastNode = null;
	}

	public T findFirstCommonNodeInConnectedLists(MyLinkedList<T> other) {
		if (areListsConnected(other)) {
			Node temp1 = this.head;
			Node temp2 = other.head;

			while (true) {
				if (temp1.next == null) {
					temp1 = other.head;
				}
				if (temp2.next == null) {
					temp2 = this.head;
				}
				if (temp1 == temp2) {
					return temp1.data;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		return null;
	}

	public T getFirstInLoop() {
		if (hasLoop()) {
			Node fastRunner = this.head;
			Node slowRunner = this.head;

			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;

			while (fastRunner != slowRunner) {
				fastRunner = fastRunner.next.next;
				slowRunner = slowRunner.next;
			}
			fastRunner = head;

			while (fastRunner != slowRunner) {
				fastRunner = fastRunner.next.next;
				slowRunner = slowRunner.next;
			}
			return slowRunner.data;
		}
		return null;
	}

	public Boolean areListsConnected(MyLinkedList<T> other) {
		return this.lastNode == other.lastNode;
	}

	public Boolean isListPalindrome() {

		Stack<T> nodeStack = new Stack<>();

		Node temp = head;

		for (int i = 0; i < size / 2; i++) {
			nodeStack.add(temp.data);
			temp = temp.next;
		}
		if (size % 2 != 0) {
			temp = temp.next;
		}
		for (int i = 0; i < size / 2; i++) {
			if (temp.data != nodeStack.pop()) {
				return false;
			}
			temp = temp.next;
		}
		return true;
	}

	public String toString() {
		String result = "";

		Node temp = head;
		while (temp != null) {
			result += temp.data + " ";
			temp = temp.next;
		}
		return result;
	}

	@Override
	public void push(T element) {
		addFirst(element);
	}

	@Override
	public void pop() {
		if (size != 0) {
			remove(0);
		}
	}

	@Override
	public void enqueue(T element) {
		addLast(element);
	}

	@Override
	public void dequeue() {
		if (size != 0) {
			remove(0);
		}
	}

	@Override
	public T peek() {
		if (size != 0) {
			return this.head.data;
		}
		return null;
	}

}
