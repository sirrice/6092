import java.util.*;

public class YourFace {

    public static void main (String[] args) {
        Person p1 = new Person ("John", 0, "New York");
        Person p2 = new Person ("Philipp", 1, "L.A.");
        Person p3 = new Person ("Jennifer", 2, "Philadelphia");

        p1.addFriend (p2);

        p1.printOut ();
    }
}

