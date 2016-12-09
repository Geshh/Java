
public class Arr {
  
  public static String toString(int[] a) {
  	String arrayToString="";

  	for(int i=0;i<a.length;i++) {
  		arrayToString += a[i] + " ";
  	}
  	return arrayToString;
  }
  
  public static void sort(int[] a) {
  	
    for(int i=0;i<a.length-1;i++) {
    	for(int j=i+1;j<a.length;j++) {
    		if(a[i]>a[j]) {
    			int temp = a[i];
    			a[i]=a[j];
    			a[j]=temp;
    		}
    	}
    }
  }
  
  public static int[] reverse(int[] a) {
  	int[] reversed = new int[a.length];

  	for(int i=a.length-1,j=0;i>=0;i--) {
  		reversed[j] = a[i];
  		j+=1;
  	}
  	return reversed;
  }
  
  public static String join(int[] a, String glue) {
  	String newString = "";
  	for(int i=0;i<a.length - 1 ;i++) {
  		newString+= a[i];
  		newString+= (glue + ' ');
  	}
  	newString+=a[a.length-1];
    return newString;
  }
  
  public static int sum(int[] a) {
  	int sum = 0;
  	for(int i=0;i<a.length;i++) {
  		sum+=a[i];
  	}
    return sum;
  }
  
  public static int[] range(int a, int b) {

  	int[] newArray = new int[Math.abs(a-b)];

  	for(int i=a,j=0;i<b;i++) {
  		newArray[j++] = i;
  	}

  	return newArray;
  }
  
  public static int[] filterOdd(int[] a) {

  	int oddCount=0;
  	for(int i=0;i<a.length;i++) {
  		if(a[i]%2!=0) {
  			oddCount+=1;
  		}
  	}

  	int[] oddArray = new int[oddCount];

  	for(int i=0,j=0;i<a.length;i++) {
  		if(a[i]%2!=0) {
  			oddArray[j++] = a[i];
  		}
  	}

    return oddArray;
  }
  
  public static void main(String[] args) {
    int[] a = {10, 20, -50, 80, 70, 66, -365};

    System.out.println("Print the array to string:");
    System.out.println(Arr.toString(a));
    
    System.out.println("Sort the array a itself and print it sorted:");
    Arr.sort(a);
    System.out.println(Arr.toString(a));
    
    
    System.out.println("Print the reverse of the sorted array");
    a = Arr.reverse(a);
    System.out.println(Arr.toString(a));
    
    System.out.println("Output each element in a with -> between them");
    System.out.println(Arr.join(a, "->"));
    
    System.out.println("Output the sum");
    System.out.println(Arr.sum(a));
    
    System.out.println("Output array with elements from 1 to 10");
    System.out.println(Arr.toString(Arr.range(1, 10)));
    
    System.out.println("Print only the odd numbers");
    System.out.println(Arr.toString(Arr.filterOdd(a)));
  }
}