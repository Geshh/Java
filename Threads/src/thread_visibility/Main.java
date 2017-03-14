package thread_visibility;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		VisibilityTask task = new VisibilityTask();
		
		Thread thread = new Thread(task);
		thread.start();
		
		Thread.sleep(1000);
		
		task.setToFalse();
		
		System.out.println("Set to false");
	}
}
