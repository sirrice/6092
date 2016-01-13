class If2 {
    public static void test(int x) {
        if (x > 5) {
            System.out.println(x + " is > 5");
        } else {
            System.out.println(x + " is not > 5");
        }
    }

    public static void main(String[] arguments) {
        test(6);
        test(5);
        test(4);
    }
}
