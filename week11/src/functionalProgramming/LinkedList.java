package functionalProgramming;

public class LinkedList<T> {

	public interface RunBool1<T> {
		boolean run(T x);
	}

	public interface RunFucn1<E, T> {
		E run(T x);
	}

	public interface RunFunc2<E, T> {
		E run(E x, T y);
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		public T data;
		public Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	Node<T> head = null;

	public void add(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> walker = head;
			while (walker.next != null) {
				walker = walker.next;
			}
			walker.next = new Node<T>(data);
		}
	}
	
	public <E> E reduce1(E startValue , RunFunc2<E,T> r) {
		E res = r.run(startValue , head.data);

		Node<T> walker = head;
		while (walker != null) {
			res = r.run(res, walker.data);
			walker = walker.next;
		}
		return res;

	}

	public <E> E reduce(E startValue, RunFunc2<E, T> r) {

		Node<T> walker = head;
		E res = startValue;

		while (walker != null) {
			res = r.run(res, walker.data);

			walker = walker.next;
		}
		return res;
	}

	public <E> LinkedList<E> map(RunFucn1<E, T> r) {
		LinkedList<E> res = new LinkedList<>();
		Node<T> walker = head;

		while (walker != null) {
			res.add(r.run((walker.data)));

			walker = walker.next;
		}

		return res;
	}

	public LinkedList<T> filter(RunBool1<T> r) {
		LinkedList<T> res = new LinkedList<>();

		Node<T> walker = head;

		while (walker != null) {

			if (r.run(walker.data)) {
				res.add(walker.data);
			}
			walker = walker.next;
		}

		return res;

	}

	public String toString() {
		if (head == null)
			return "[]";
		String res = "";

		Node<T> walker = head;
		while (walker.next != null) {
			res += walker.data + " , ";
			walker = walker.next;
		}
		return "[ " + res + walker.data + " ]";
	}
}
