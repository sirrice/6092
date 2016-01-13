class Marathon {
    public static void main (String[] arguments) {
        String names[] = {
            "John", "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
            "Alex", "Emma", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int times[] = {
            243, 341, 273, 278, 329, 445, 402, 388, 275, 334, 412, 393, 299,
            343, 317, 265
        };

        for (int i=0;i<names.length;i++) {
            System.out.println(names[i] + " : " + times[i]);
        }
    }
}
