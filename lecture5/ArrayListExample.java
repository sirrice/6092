import java.util.ArrayList;

class ArrayListExample {
    public static void main(String[] arguments) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Olivier");
        strings.add("Evan");
        strings.add("Phil");

        System.out.println(strings.size());
        System.out.println(strings.get(0));
        System.out.println(strings.get(1));

        strings.set(0, "Goodbye");
        strings.remove(1);

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
