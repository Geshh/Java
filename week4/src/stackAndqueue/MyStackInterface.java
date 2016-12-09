package stackAndqueue;

/**
 * Stack interface
 * 
 * @author Geshh
 *
 * @param <T> should implement Comparable Interface.
 */

public interface MyStackInterface<T extends Comparable<T> > {
	
	/**
	 * Adds an element on top of the stack
	 * 
	 * @param element
	 */
	public void push(T element);
	
	/**
	 * Removes the element on top of the stack.
	 */
	public void pop();	
	
	/**
	 * 
	 * @return the element on top of the stack
	 */
	public T peek();

	/**
	 * 
	 * @return the number of elements in the stack.
	 */
	public int getSize();
}
