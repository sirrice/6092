class BreakExample {

    public static void main (String[] arguments) {

        for (int i=0; i<100; i++) {
	        if(i == 10)
	            break;
	        else {
                System.out.println("This is line " + i);
            }
	    }
    }
}

