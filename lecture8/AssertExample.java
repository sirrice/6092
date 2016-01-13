class AssertExample{

	public static void main(String args[]) {

		System.out.println( fahrenheitToCelsius(95) );

		System.out.println( fahrenheitToCelsius(-460) );
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
			
		assert fahrenheit >= -459.67d : "input temp < aboslute zero";
			
		double celsius = (fahrenheit -32) / 9 * 5;
		return celsius;
	}
}