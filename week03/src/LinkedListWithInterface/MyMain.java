package LinkedListWithInterface;

public class MyMain {
	
	public static void main(String[] args) {

		MyLinkedList<Integer> mylist = new MyLinkedList<>();

		for (int i = 0; i < 10; i++) {
			mylist.addFirst(i);
		}
		System.out.println(mylist);
		
		MyLinkedList<Integer> mylist2 = new MyLinkedList<>();
		
		for(int i=0;i<10;i++) {
			mylist2.addLast(i);
		}
		System.out.println(mylist2);
		
		System.out.println(mylist2.getKthElFromBehind(5));
//		//mylist.addListFix(mylist2);
//		//S1ystem.out.println(mylist);
		System.out.println(mylist.getLast());
		System.out.println(mylist2.getLast());
		mylist.addList(mylist2);
		System.out.println(mylist);
		System.out.println(mylist.getLast());
		
		System.out.println(mylist.isListPalindrome());
//		
//		System.out.println(mylist.getFirst());
//		System.out.println(mylist2.getLast());
//		System.out.println(mylist.get(1));
//		System.out.println(mylist2.get(1));
//		mylist2.remove(2);
//		System.out.println(mylist2);
		mylist.partitionList(5);
		System.out.println(mylist);
		mylist.remove(mylist.getSize()-1);
		System.out.println(mylist);
		
		System.out.println(mylist.getFirstInLoop());
		
		
	}
}
