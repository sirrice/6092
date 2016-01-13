import java.util.*;

public class Network implements SocialEntity {
    protected String name;
    protected long id;
    protected ArrayList<Person> people;

    public Network (String name, long id) {
        this.name = name;
        this.id = id;
        this.people = new ArrayList<Person> ();
    }

    public String getName () {
        return name;
    }

    public long getId () {
        return id;
    }

    public void addMember (Person p) {
        people.add (p);
        p.addNetwork (this);
    }
}

