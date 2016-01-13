import java.util.*;

public class Band implements SocialEntity {
    protected String name;
    protected long id;
    protected ArrayList<Person> fans;

    public Band (String name, long id) {
        this.name = name;
        this.id = id;
        this.fans = new ArrayList<Person> ();
    }

    public String getName () {
        return name;
    }

    public long getId () {
        return id;
    }

    public void addFan (Person p) {
        fans.add (p);
    }
}

