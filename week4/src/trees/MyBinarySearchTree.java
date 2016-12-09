package trees;

import java.util.List;
import java.util.Vector;

public class MyBinarySearchTree<T extends Comparable<T>> implements MyBinarySearchTreeInterface<T> {

	private class Node {
		private T data;
		private Node left;
		private Node right;

		public Node(T element) {
			this.data = element;
			this.left = null;
			this.right = null;
		}

		public Node(T element, Node left, Node right) {
			this.data = element;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;

	public MyBinarySearchTree() {
		root = null;
	}

	public void sortArr(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.insert(arr[i]);
		}
		sortArr(this.root, arr, 0);
	}

	private int sortArr(Node cur, T[] arr, int index) {
		if (cur != null) {
			index = sortArr(cur.left, arr, index);
			arr[index++] = cur.data;
			index = sortArr(cur.right, arr, index);
		}
		return index;
	}

	public static Vector<Integer> sortVector(Vector<Integer> vec) {
		MyBinarySearchTree<Integer> f = new MyBinarySearchTree<>();
		for (int i = 0; i < vec.size(); i++) {
			f.insert(vec.get(i));
		}
		vec.clear();
		putElIntoVec(f.root, vec);
		return vec;
	}

	private static void putElIntoVec(MyBinarySearchTree<Integer>.Node current, Vector<Integer> vec) {
		if (current != null) {
			putElIntoVec(current.left, vec);
			vec.addElement(current.data);
			putElIntoVec(current.right, vec);
		}
	}

	private void printRecursively(Node current) {
		if (current != null) {
			printRecursively(current.left);
			System.out.print(current.data + " ");
			printRecursively(current.right);
		}
	}

	@Override
	public void print() {
		printRecursively(root);
	}

	private void insertRecursively(T element, Node current) {
		if (element.compareTo(current.data) <= 0) {
			if (current.left != null) {
				insertRecursively(element, current.left);
			} else {
				current.left = new Node(element);
			}
		} else {
			if (current.right != null) {
				insertRecursively(element, current.right);
			} else {
				current.right = new Node(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (root == null) {
			root = new Node(element);
		} else {
			insertRecursively(element, root);
		}
	}

	private void findMinParent(Node current, Node nodeToDelete) {
		if (current.right == null) {
			nodeToDelete.data = current.data;
			removeNodeFromParent(nodeToDelete, current);
		} else {
			while (current.right.right != null) {
				current = current.right;
			}
			nodeToDelete.data = current.right.data;
			removeNodeFromParent(current, current.right);
			// current.right = null;
		}
	}

	private void removeNodeFromParent(Node parent, Node nodeToDelete) {
		// case 1 : no children
		if (nodeToDelete.left == null && nodeToDelete.right == null) {
			if (parent.left != null && nodeToDelete.data == parent.left.data) {
				parent.left = null;
			} else if (parent.right != null) {
				parent.right = null;
			}
		}
		// case 2 : one child
		else if (nodeToDelete.left == null) {
			if (parent.left != null && nodeToDelete.data == parent.left.data) {
				parent.left = nodeToDelete.right;
			} else if (parent.right != null) {
				parent.right = nodeToDelete.right;
			}
		} else if (nodeToDelete.right == null) {
			if (parent.left != null && nodeToDelete.data == parent.left.data) {
				parent.left = nodeToDelete.left;
			} else if (parent.right != null) {
				parent.right = nodeToDelete.left;
			}
		}
		// case 3 : two children
		else {
			findMinParent(nodeToDelete.left, nodeToDelete);
		}
	}

	private void findNodeToRemove(T element, Node current) {
		if (current.left == null && current.right == null) {
			return;
		} else {
			if (current.left != null && element == current.left.data) {
				removeNodeFromParent(current, current.left);
			} else if (current.right != null && element == current.right.data) {
				removeNodeFromParent(current, current.right);
			} else if (element.compareTo(current.data) < 0) {
				findNodeToRemove(element, current.left);
			} else {
				findNodeToRemove(element, current.right);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (root != null) {
			if (root.data == element) {
				removeNodeFromParent(root, root);
			} else {
				findNodeToRemove(element, root);
			}
		}
	}

	private boolean findRecursively(T element, Node current) {
		if (current.data == element) {
			return true;
		} else {
			if (element.compareTo(current.data) <= 0) {
				if (current.left != null) {
					return findRecursively(element, current.left);
				} else {
					return false;
				}
			} else {
				if (current.right != null) {
					return findRecursively(element, current.right);
				} else {
					return false;
				}
			}
		}
	}

	@Override
	public boolean find(T element) {
		return findRecursively(element, root);
	}

	public boolean checkIfEqual(Node first, Node second) {
		if (first == null && second != null || first != null && second == null) {
			return false;
		} else if (first == null && second == null) {
			return true;
		} else {
			return (first.data == second.data && checkIfEqual(first.left, second.left)
					&& checkIfEqual(first.right, second.right));
		}
	}

	public boolean areEqual(MyBinarySearchTree<T> other) {
		return checkIfEqual(this.root, other.root);
	}

	@Override
	public T getRoot() {
		return root.data;
	}

	public int size() {
		return size(root);
	}

	private int size(Node current) {
		if (current == null) {
			return 0;
		}
		return 1 + size(current.left) + size(current.right);
	}

	public void buildTreeFromList(List<T> list) {
		this.root = buildTreeFromListRec(list);
	}

	private Node buildTreeFromListRec(List<T> list) {
		if (list.isEmpty()) {
			return null;
		}
		int mid = list.size() / 2;
		T value = list.get(mid);

		Node left = buildTreeFromListRec(list.subList(0, mid));
		Node right = buildTreeFromListRec(list.subList(mid + 1, list.size()));

		return new Node(value, left, right);
	}

	private int getMaxDepthRec(Node current) {
		if (current == null) {
			return 0;
		} else {
			return 1 + Math.max(getMaxDepthRec(current.left), getMaxDepthRec(current.right));
		}
	}

	public int getMaxDepth() {
		return getMaxDepthRec(root);
	}

}
