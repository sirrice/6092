import java.util.*;

public class Band implements SocialEntity {
    protected String name;
    protected long id;
    protected ArrayList<Person> musicians;

    public String getName () {
        return name;
    }

    public long getId () {
        return id;
    }
}

