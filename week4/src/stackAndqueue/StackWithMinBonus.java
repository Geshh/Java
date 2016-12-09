package stackAndqueue;

public class StackWithMinBonus<T extends Comparable<T>> implements MyStackInterface<T> {

	private MyStackInterface<T> stack;
	private MyStackInterface<T> minData;

	public StackWithMinBonus() {
		stack = new MyLinkedList<>();
		minData = new MyLinkedList<>();
	}

	public T getMinElement() {
		if (stack.getSize() != 0) {
			return minData.peek();
		}
		return null;
	}

	@Override
	public void push(T element) {
		if(minData.getSize() == 0) {
			minData.push(element);
		}
		if (minData.peek().compareTo(element) >= 0) {
			minData.push(element);
		}
		stack.push(element);
	}

	@Override
	public void pop() {
		if (stack.peek() == minData.peek()) {
			minData.pop();
		}
		stack.pop();
	}

	@Override
	public T peek() {
		return stack.peek();
	}

	@Override
	public int getSize() {
		return stack.getSize();
	}
}
