import java.util.*;
import java.lang.Math;

public class YourFace {

    public static void main (String[] args) {

        String[] names = { "Paul", "Simon", "Elvis", "Jennifer", "Sonia", "Soohoo", "Mark" };
        String[] locations = { "N.Y.", "Boston", "Cambridge", "Chicago", "L.A.", "Austin", "Miami" };

        // create seven persons
        ArrayList<Person> people = new ArrayList<Person> ();
        for (int i=0;i<7;i++) {
            Person p = new Person (names[i], i, locations[i]);
            people.add (p);
        }

        // create two networks
        Network n1 = new Network ("Geeks", 0);
        Network n2 = new Network ("Runners", 1);

        // create two bands
        Band b1 = new Band ("Broken apples", 0);
        Band b2 = new Band ("Ciao Manu", 1);

        // add friends
        for (Person p : people) {
            for (Person q : people) {
                if (p.getId () != q.getId() && Math.abs(p.getId() - q.getId()) < 5) {
                    p.addFriend (q);
                }
            }
        }

        // add to networks
        for (Person p : people) {
            if (p.getId() < 3) {
                n1.addMember (p);
            } else {
                n2.addMember (p);
            }
        }

        // add to bands
        b1.addFan (people.get(0));
        b1.addFan (people.get(1));
        b2.addFan (people.get(2));

        // print people out 
        for (Person p : people) {
            p.printOut ();
        }
    }
}

