import java.util.HashMap;
import java.util.Map;

class MapExample {
    public static void main(String[] arguments) {
        HashMap<String, String> strings = new HashMap<String, String>();
        strings.put("Olivier", "koch@csail.mit.edu");
        strings.put("Evan", "evanj@mit.edu");
        strings.put("Phil", "pcm@csail.mit.edu");

        System.out.println(strings.size());

        strings.remove("Evan");

        for (String s : strings.keySet()) {
            System.out.println(s);
        }
        for (String s : strings.values()) {
            System.out.println(s);
        }
        for (Map.Entry<String, String> pairs : strings.entrySet()) {
            System.out.println(pairs);
        }
    }
}
