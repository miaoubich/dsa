package org.miaoubich;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;

public class Java11Features {

	public static void main(String[] args) {
		// Before Java 11
		BinaryOperator<String> concatenate = (s1, s2) -> s1 + s2;

//		varExample();
//		lineString();
//		predicateNotExample();
//		demonstrateToArray();
//		demonstrateStringMethods();
//		patternMatchingSwitch();
//		randomExample();
		strictFloatingPoint();

	}

	// Example of using var in a method
	public static void varExample() {
		var list = List.of("apple", "banana", "cherry");
		for (var fruit : list) {
			System.out.println(fruit);
		}
		// With Java 11
		BinaryOperator<String> concatenate = (var s1, var s2) -> s1 + s2;
		System.out.println(concatenate.apply("Hello, ", "World!"));
	}

	public static void lineString() {
		String line = "First line\nSecond line\nThird line \nSecond line";

		System.out.println("Original String\n " + line);
		System.out.println("Lines: " + line.lines().count());
		System.out.println("Lines: " + line.lines().collect(Collectors.toList()));
		System.out.println("Lines: " + line.lines().distinct().collect(Collectors.toList()));
	}

	public static void predicateNotExample() {
		List<String> list = List.of("apple", "banana", "", "cherry");
		System.out.println("List: " + list);
		// remove empty strings before JAVA11
		System.out.println(
				"Filtered List before java11: " + list.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()));
		// remove empty strings after JAVA11
		System.out.println("Filtered List after java11: "
				+ list.stream().filter(Predicate.not(String::isEmpty)).collect(Collectors.toList()));
	}

	public static void demonstrateToArray() {
		List<String> list = List.of("apple", "banana", "cherry");
		String[] arrayBeforeJava11 = list.toArray(new String[0]);
		System.out.println("Array before java11: " + String.join(", ", arrayBeforeJava11) + "\n"
				+ "arrayBeforeJava11[1] = " + arrayBeforeJava11[1]);
		System.out.println("Array -> " + Arrays.toString(arrayBeforeJava11));

		String[] arrayAfterJava11 = list.toArray(String[]::new);
		System.out.println("Array after java11: " + String.join(", ", arrayAfterJava11));
	}

	public static void demonstrateStringMethods() {
		// Example of the new String methods
		String str = "Hello World";
		System.out.println(str.isBlank()); // false
		System.out.println(str.repeat(3)); // Hello WorldHello WorldHello World
		System.out.println(str.lines().count()); // 1
		System.out.println(str.lines().collect(Collectors.toList())); // [Hello World]
		System.out.println(str.isEmpty()); // false
		System.out.println(str.isBlank()); // false

		// Example of the new String methods with whitespace
		String str1 = "\u00A0   Hello World\u00A0   ";
		str1 = str1.replace('\u00A0', ' '); 
		System.out.println("[" + str1.strip() + "]"); // "Hello World"
		System.out.println("[" + str1.stripLeading() + "]"); // "Hello World  "
		System.out.println("[" + str1.stripTrailing() + "]"); // "  Hello World"
	}
	
//	public static void patternMatchingSwitch() {
//		Object obj = 12;
//		switch (obj) {
//		case String s -> System.out.println("String: " + s);
//		case Integer i -> System.out.println("Integer: " + i);
//		case null -> System.out.println("null");
//		default -> System.out.println("Unknown type");
//		}
//	}
	
	public static void randomExample() {
		RandomGenerator random = RandomGeneratorFactory.of("L128X256MixRandom").create();
		System.out.println("Random number: " + random.nextInt(100));
	}

	public static void strictFloatingPoint() {
		double a = 0.1;
		double b = 0.2;
		double c = a + b;
		System.out.println("Result: " + c);
	}

}
