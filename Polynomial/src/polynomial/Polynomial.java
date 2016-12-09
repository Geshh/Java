package polynomial;

public class Polynomial {

	private int size;
	private int[] arr;
	
	public Polynomial() {
		size=1;
		arr = new int[size];
	}
	
	public Polynomial(int size) {
		this.size=size;
		arr= new int[size];
	}

	public Polynomial(Polynomial other) {
		this.size=other.size;
		this.arr = new int[this.size];
		
		for(int i=0;i<size;i++) {
			this.add(other.arr[i], i);
		}
	}
	
	public void add(int data , int power) {
		if(power>=size) {
			resize(power);
		}
		arr[power]+= data;
	}
	
	public int size() {
		return size;
	}
	
	public void substract(int data , int power) {
		arr[power] -= data;
	}
	
	public void multiplicate(int data, int power) {
		arr[power] *= data;
	}
	
	public void resize(int power) {
		int[] temp = new int[power+1];
		
		for(int i=0;i<size;i++) {
			temp[i]=arr[i];
		}
		for(int i=size;i<power;i++) {
			temp[i]=0;
		}
		size=power+1;
		arr=temp;
	}
	
	public Polynomial polySum(Polynomial other) {
		for(int i=0;i<other.size;i++) {
			this.add(other.arr[i], i);
		}
		return this;
	}
	
	public Polynomial polySumBoth(Polynomial one , Polynomial two) {
		Polynomial newVec = new Polynomial(one);
		
		for(int i=0;i<two.size;i++) {
			newVec.add(two.arr[i], i);
		}
		return newVec;
	}
	
	public Polynomial polySubstract(Polynomial other) {
		for(int i=0;i<other.size;i++) {
			this.substract(other.arr[i], i);
		}
		return this;
	}

//	public Polynomial polySubstract(Polynomial one , Polynomial two) {
//		Polynomial newVec = new Polynomial(one);
//		
//		for(int i=0;i<two.size;i++) {
//			newVec.substract(two.arr[i],i);
//		}
//		return newVec;
//	}
	
	public Polynomial polyMultiplicate(Polynomial one , Polynomial two) {
		Polynomial newVec = new Polynomial(one);
		
		for(int i=0;i<two.size;i++) {
			newVec.multiplicate(two.arr[i], i);
		}
		return newVec;
	}
	
	public Polynomial polyMultiByConstant(Polynomial one , int constant) {
		Polynomial newVec = new Polynomial(one);
		
		for(int i=0;i<one.size;i++) {
			newVec.multiplicate(constant, i);
		}
		return newVec;
	}
	
	public Polynomial firstDerivative() {
		Polynomial newVec = new Polynomial(this.size-1);
		
		for(int i=1;i<size;i++) {
			newVec.arr[i-1] = this.arr[i]*i;
		}
		return newVec;
	}
	
	public int evaluate(int x) {
		int result=0;
		
		for(int i=0;i<size;i++) {
			result+= arr[i]*(Math.pow(x,i));
		}
		return result;
	}
	
	public String toString() {
		String polynom = "";
		
		polynom+= arr[size-1] + "x^" + (size-1);
		
		for(int i=size-2;i>=1;i--) {
			if(arr[i]==0) {
				continue;
			} else {
				if(arr[i]>0) {					
					polynom+= " +";
				}
				polynom += " " + arr[i] + "x^" + i;
			}

		}
		if(arr[0]!=0) {			
			polynom+= " + " + arr[0];
		}
		return polynom;
	}
	
	public static Polynomial fromString(String polynom) {
		
		Polynomial newVec = new Polynomial();
		
		polynom = polynom.replaceAll(" ", "");
		String[] parts = polynom.split("\\+");
		
		String current = "";
		for(int i=0;i<parts.length;i++) {
			current = parts[i];
			String[] otherParts = current.split("\\^");
			if(otherParts[0].contains("x")) {
				otherParts[0] = otherParts[0].substring(0, otherParts[0].length()-1);
			}
			
			if(otherParts.length>1) {				
				newVec.add(Integer.parseInt(otherParts[0]),
						Integer.parseInt(otherParts[1]));
			} else {
				newVec.add(Integer.parseInt(otherParts[0]), 0);
			}
		}
		return newVec;
	}
	
}
