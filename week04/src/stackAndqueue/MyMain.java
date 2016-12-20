package stackAndqueue;

public class MyMain {
	public static void main(String[] args) {

		QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<>();
		for(int i=0;i<5;i++) {
			q.enqueue(i);
		}
		
		StackWithMinBonus<Integer> st = new StackWithMinBonus<>();
		st.push(2);
		st.push(-1);
		st.push(1);
		st.push(-1);
		System.out.println(st.getMinElement());
	
	}
}
