package org.miaoubich;

public class GameStreamJava8 {

	public static void main(String[] args) {

		StringOperator trim = String::trim;//s->s.trim();
		StringOperator capitalize = StringOperator.capitalize();
		
		StringOperator capitalizeAndTrim = trim.andThen(capitalize);
		
		String input = "   hello world   ";
		
		String result = capitalizeAndTrim.apply(input);
		
		System.out.println("Original: '" + input + "'");
		System.out.println("Transformed: '" + result + "'");
	}	

}
