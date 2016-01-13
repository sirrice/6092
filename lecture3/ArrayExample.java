class ArrayExample {

    public static void main (String[] arguments) {

        int values[] = { 12, 24, -23, 47 };

        System.out.println ("Value at index 3 is " + values[3]);
		values[3] = 18;    // write
        System.out.println ("Value at index 3 is " + values[3]);

        int x = values[1] + 3; // read
        System.out.println ("Value at index 1 is " + values[1]);
        System.out.println ("Value of x is " + x);

    }
}


