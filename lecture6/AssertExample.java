public class AssertExample {
    static int findMinimum(int[] list) {
        int min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < list[i-1]) {
                min = list[i];
            }
        }
        return min;
    }

    static void printDifferenceFromFastest(int[] marathonTimes) {
        int fastestTime = findMinimum(marathonTimes);

        for (int time : marathonTimes) {
            int difference = time - fastestTime;
            assert difference >= 0;
            System.out.println("Difference: " + difference);
        }
    }

    public static void main(String[] arguments) {
        int[] times = { 233, 137, 221, 212 };
        printDifferenceFromFastest(times);        
    }
}
