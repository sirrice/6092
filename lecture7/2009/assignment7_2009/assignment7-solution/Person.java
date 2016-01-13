import java.util.*;

public class Person implements SocialEntity {

    protected String name;
    protected long id;
    protected ArrayList<Person> friends;
    protected ArrayList<Network> networks;
    protected String location;

    public Person (String name, long id, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.friends = new ArrayList<Person> ();
        this.networks = new ArrayList<Network> ();
    }

    public String getName () {
        return name;
    }

    public long getId () {
        return id;
    }

    public void printOut () {
        System.out.println ("My name is " + name  + " and I have " + friends.size() + " friends.");
        if (friends.size() > 0) {
            for (Person p : friends) {
                System.out.println (p.getName());
            }
        }
        System.out.println ("I belong to " + networks.size() + " networks.");
        if (networks.size() > 0) {
            for (Network n : networks)  {
                System.out.println (n.getName());
            }
        }
    }

    public void addNetwork (Network n) {
        networks.add (n);
    }

    public void addFriend (Person f) {
        this.friends.add (f);
    }
}

