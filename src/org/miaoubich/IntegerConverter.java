package org.miaoubich;

public class IntegerConverter {

	public static void main(String[] args) {
		Integer monthYear = 122025;
//		System.out.println("monthYear -> " + monthYear);
//		System.out.println("yearMonth -> " + converter(monthYear));
		
		swap(7, 10);
	}
	//12026
	//(c.month_year % 10000) * 100 + (c.month_year/10000)
	private static long converter(Integer monthYear) {
		Integer a = monthYear % 10000;
		Integer b = monthYear / 10000;
		Integer c = a * 100;
		System.out.println("a -> " + a);
		System.out.println("c -> " + c);
		System.out.println("b -> " + b);
		
		Integer yearMonth = monthYear % 10000 * 100 + monthYear / 10000;
		return yearMonth;
	}
	
	public static void swap(long a, long b) {
		System.out.print("Before swap: ");
		System.out.println("a -> " + a + ", b -> " + b);
		
        a = a + b - (b = a);
        
        System.out.print("After swap: ");
        System.out.println("a -> " + a + ", b -> " + b);
    }

	
}
