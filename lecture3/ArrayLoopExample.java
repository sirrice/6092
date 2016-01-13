class ArrayLoopExample {

    public static void main (String[] arguments) {

		int values[] = new int[5];

		for (int i=0;i<values.length;i++) {
			values[i] = i;
			int y = values[i] * values[i];
			System.out.println(y);
		}
    }
}


