
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface MyCondition {
	boolean test(int l);
}

@FunctionalInterface // @FunctionalInterface IS RECOMMENDED TO WRITE ON TOP OF FUNCTIONAL INTERFACE
interface I {
	int accept(int i);
}

public class DemoFunctional 
{
	public static void main(String[] args) {

//I i1 = (int i) -> {return i;};
//I i2 = (i) -> {return i;};
//I i3 = i -> {return i;};
//I i4 = i -> i;
//I i5 = i -> return i; //when we use return keyword { } are MUST

		List<String> cities = new ArrayList<>();
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Delhi");
		cities.add("Hyd");

		// printCitiesByNameLength(cities, 5);

		// If somehow if I can pass function as an argument to a method
		// Treating function as value
		// to do this Lambdas are introduced in jdk 8
		// Following are valid lambads for MyCondition
		// All are functionally same
//		MyCondition c0 =  (int l) -> { return (l > 5); };
//		MyCondition c1 = (int l) -> { if(l>5) return true; else return false; };	
//		MyCondition c2 = (l) -> { if(l>5) return true; else return false; };	//data types for arguments is optional
//		
//		MyCondition c3 = l -> { if(l>5) return true; else return false; };	//() is optional if ONLY one argument
//		
//		MyCondition c4 = l -> l>4;		//single line in lambda hence { }  optional 
//										//Write lambdas as concise as possible

//		print(cities, l -> l>4 );
//		print(cities,c4);
//		print(cities,c3);
//		print(cities,c2);

		genericPrint(cities, c -> c == 'M');

	}

	static void genericPrint(List<String> cities , Predicate<Character> p)
	{
		for (String c : cities) {
			
		}
	}
	
//	static void printConditionally(List<String> cities, Predicate<Character> p) {
//		System.out.println("--------------------Here---------------");
//		for (String c : cities) {
//			if (p.test(c.charAt(0)))
//				System.out.println(c);
//		}
//	}

//	static void printConditionally(List<String> cities,Predicate<Integer> p)
//	{
//		for (String c : cities) {
//			if(p.test(c.length()))
//				System.out.println(c);
//		}
//	}
//	
//	static void print(List<String> cities,MyCondition condi)
//	{
//		for (String c : cities) {
//			if(condi.test(c.length()))
//				System.out.println(c);
//		}
//	}

	// in following methods ONLY condition functionality is different
//	static void printCitiesStartsWith(List<String> cities, char ch) {
//		for (String c : cities) {
//			if (c.charAt(0) == ch)
//				System.out.println(c);
//		}
//	}

//	static void printCitiesByNameLength(List<String> cities, int length) {
//		for (String c : cities) {
//			if (c.length() > length)
//				System.out.println(c);
//		}
//	}
}
