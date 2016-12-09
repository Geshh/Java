package trees;

/**
 * Binary Search Tree Interface 
 * 
 * @author Geshh
 *
 * @param <T> should implement Comparable Interface
 * 
 */

public interface MyBinarySearchTreeInterface<T extends Comparable<T>> {

	/**
	 * Insert element in binary tree
	 * 
	 * @param element
	 */
	public void insert(T element);
	
	/**
	 * Remove the element from binary tree
	 * 
	 * @param element
	 */
	public void remove(T element);
	
	/**
	 * Find element in binary tree
	 * 
	 * @param element
	 * 
	 * @return element
	 */
	public boolean find(T element);
	
	/**
	 * Returns root data
	 * 
	 * @return root data
	 */
	public T getRoot();
	
	public void print();
	
	
	
	
	
}
