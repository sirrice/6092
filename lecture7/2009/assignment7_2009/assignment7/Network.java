import java.util.*;

public class Network implements SocialEntity {
    protected String name;
    protected long id;
    protected ArrayList<Person> people;

    public String getName () {
        return name;
    }

    public long getId () {
        return id;
    }
}

