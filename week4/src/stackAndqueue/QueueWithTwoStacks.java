package stackAndqueue;

public class QueueWithTwoStacks<T extends Comparable<T>> implements MyQueueInterface<T> {

	private MyStackInterface<T> pushStack;
	private MyStackInterface<T> popStack;

	public QueueWithTwoStacks() {
		pushStack = new MyLinkedList<>();
		popStack = new MyLinkedList<>();
	}

	@Override
	public void enqueue(T element) {
		pushStack.push(element);
	}

	@Override
	public void dequeue() {
		if(popStack.getSize()!=0) {
			popStack.pop();
		} else {
			int size = pushStack.getSize();
			for(int i=0;i<size;i++) {
				popStack.push(pushStack.peek());
				pushStack.pop();
			}
			popStack.pop();
		}
	}

	@Override
	public T peek() {
		if(popStack.getSize()!=0) {
			return popStack.peek();
		} else {
			int size = pushStack.getSize();
			for(int i=0;i<size;i++) {
				popStack.push(pushStack.peek());
				pushStack.pop();
			}
			return popStack.peek();
		}
	}

	@Override
	public int getSize() {
		return (popStack.getSize() + pushStack.getSize());
	}

}
