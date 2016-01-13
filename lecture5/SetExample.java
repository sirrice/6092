import java.util.TreeSet;

class SetExample {
    public static void main(String[] arguments) {
        TreeSet<String> strings = new TreeSet<String>();
        strings.add("Olivier");
        strings.add("Evan");
        strings.add("Phil");

        System.out.println(strings.size());
        System.out.println(strings.first());
        System.out.println(strings.last());

        strings.remove("Evan");

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
