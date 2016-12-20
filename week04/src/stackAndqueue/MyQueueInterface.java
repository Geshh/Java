package stackAndqueue;

/**
 * Queue Interface
 * 
 * @author Geshh
 *
 * @param <T> should implement the Comparable Interface
 */

public interface MyQueueInterface<T extends Comparable<T>> {

	/**
	 * Adds an element to the end of the queue.
	 * 
	 * @param element to add
	 */
	public void enqueue(T element);
	
	/**
	 * Removes the first element in the queue.
	 */
	public void dequeue();
	
	/**
	 * 
	 * @return the first element in the queue.
	 */
	public T peek();

	/**
	 * 
	 * @return the number of elements in the queue.
	 */
	public int getSize();
}
