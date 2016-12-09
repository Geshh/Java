package polynomial;

public class MyMain {

	public static void main(String[] args) {
		
		Polynomial vec = new Polynomial();
		vec.add(10,0);
		vec.add(15, 1);
		vec.add(65, 8);
		System.out.println("vec1: " + vec);
		System.out.println();
		
//		Polynomial vec2 = new Polynomial();
//		vec2.add(16, 2);
//		vec2.add(34, 5);
//		System.out.println("vec2: " + vec2);
//		System.out.println();
//		
//		Polynomial vecTest = new Polynomial();
//		vecTest.polySum(vec2);
//		System.out.println("vec16: " + vecTest);
//		System.out.println();
//		
//		Polynomial vec3 = new Polynomial();
//		vec3 = vec3.polySumBoth(vec, vec2);		
//		System.out.println("vec3: " + vec3);
//		System.out.println();
//		
//		Polynomial vec4 = new Polynomial();
//		vec4 = vec4.polyMultiByConstant(vec, 5);
//		System.out.println("vec4: " + vec4);
//		System.out.println();
//		
//		Polynomial vec5 = new Polynomial();
//		vec5 = vec5.polyMultiplicate(vec, vec2);
//		System.out.println("vec5: " + vec5);
//		System.out.println();
//		
//		Polynomial vec6 = new Polynomial();
//		vec6 = vec6.polySubstract(vec, vec2);
//		System.out.println("vec6: " + vec6);
//		System.out.println();
//		
//		Polynomial vec7 = new Polynomial(vec3);
//		vec7 = vec7.firstDerivative();
//		System.out.println("vec7 first derivative from vec3: " + vec7);
//		System.out.println();
//		
//		System.out.println("Evaluate vec1, x = 5 : " + vec.evaluate(5));
//		System.out.println();
//		System.out.println();
//		
//		Polynomial vec8 = new Polynomial();
//		vec8 = Polynomial.fromString("15x^2 + 18x^4 + 10 + 5x^2 + -2x^8");
//		System.out.println(vec8);

		
	}

}
