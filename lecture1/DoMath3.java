class DoMath3 {
    public static void main(String[] arguments) {
        double score = 1 + 2 * 3;
        System.out.println(score);
        double copy = score;
        copy = copy / 2;
        System.out.println(copy);
        score = (int) copy;
        System.out.println(score);
    }
}
