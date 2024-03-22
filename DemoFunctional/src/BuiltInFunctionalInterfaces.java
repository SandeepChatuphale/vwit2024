

//added in jdk 1.8
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {

	public static void main(String[] args) {

		Predicate<String> p;
		p.test("a");
		//accepts one argument and return boolean 
		
		
		Consumer<String>c;
		c.accept("");
		//accept one argument return void
		
		Supplier<String> s;
		s.get();
		//Accept nothing return one value 
		
				//type of argument - String
				//type of return value is Integer
		Function<String, Integer> f;
		
		
		f.apply("");
		//accepts one argument and return one
	}

}
