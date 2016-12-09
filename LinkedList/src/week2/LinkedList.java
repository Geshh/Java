package week2;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
	
	private class Node {
		T data;
		Node next;
		
		public Node(T data) {
			this.data=data;
			next = null;
		}
	}
	
	private Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public void add(T data) {
		if(head == null) {
			head = new Node(data);
		} else {
			Node temp = head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=new Node(data);
		}
	}
	
	public String toString() {
		String result="";
		
		Node temp = head;
		while(temp!=null) {
			result+=temp.data + " ";
			temp=temp.next;
		}
		return result;
	}
	
	public void insertAfter(T after , T data) {
		Node temp = head;
		while(temp.next.data!=after) {
			temp=temp.next;
		}
		
		Node n = new Node(data);
		n.next=temp.next;
		temp.next=n;
	}
	
	public class LLIterator implements Iterator<T>{

		private Node cursor;
		
		public LLIterator() {
			cursor=head;
		}
		
		@Override
		public boolean hasNext() {
			return cursor.next!=null;
		}

		@Override
		public T next() {
			T result = cursor.data;
			cursor=cursor.next;
			return  result;
		}
		
		@Override
		public void remove() {
			
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		return new LLIterator();
	}
	
	
	
}
