@FunctionalInterface
interface MyConsumer{
	void display(String str);
}
public class DemoMethodReference {

	public static void main(String[] args) {
		
		MyConsumer m = str -> System.out.println(str);			//it is lambda expression
																//lambda expression is implementation of method given by
																//@FunctionalInterface
		
		//this is syntax of method reference for static method
		MyConsumer m1 = Test::print;							//method reference
																//it is short cut way of writing lambdas
																//It is MUST that signature MUST match
		m1.display("Hello WOrld");
		//this is syntax of method reference for non-static method
		MyConsumer m2 = new Test()::show;	
		m2.display("Hello World");
		MyConsumer m3 = System.out::println;
		m3.display("Hello World");
	}
}
class Test
{
	static void print(String s){
		System.out.println("Using Print " + s);
	}
	void show(String s){
		System.out.println("USing show " + s);
	}
}
