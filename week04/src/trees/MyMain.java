package trees;

import java.util.ArrayList;
import java.util.List;

public class MyMain {
	public static void main(String[] args) {

//		MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
//
//		tree.insert(14);
//		tree.insert(10);
//		tree.insert(18);
//		tree.insert(8);
//		tree.insert(9);
//		tree.insert(11);
//		tree.insert(5);
//		tree.print();
//
//		MyBinarySearchTree<Integer> tree2 = new MyBinarySearchTree<>();
//		System.out.println();
//		tree2.insert(14);
//		tree2.insert(10);
//		tree2.insert(18);
//		tree2.insert(8);
//		tree2.insert(9);
//		tree2.insert(11);
//		tree2.insert(5);
//		tree2.print();
//
//		System.out.println(tree.areEqual(tree2));
//
//		Integer[] arr = { 1, 5, 3, 4, 7, 6 };
//		MyBinarySearchTree<Integer> t = new MyBinarySearchTree<Integer>();
//		t.sortArr(arr);
//		t.print();
//		
//		Vector<Integer> vec = new Vector<>();
//		vec.add(5);
//		vec.add(4);
//		vec.add(10);
//		vec.add(1);
//		vec = MyBinarySearchTree.sortVector(vec);
//		System.out.println(vec);
		List<Integer> lst = new ArrayList<>();
		for(int i=0;i<10;i++) {
			lst.add(i);
		}
		
		MyBinarySearchTree<Integer> t = new MyBinarySearchTree<>();
		t.buildTreeFromList(lst);
		t.print();
		//System.out.println(t.size());
		System.out.println();
		System.out.println(t.getMaxDepth());
	}
}
