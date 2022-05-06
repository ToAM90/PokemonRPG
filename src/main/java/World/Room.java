package World;

import java.util.ArrayList;
import java.util.List;

public class Room {

    public int number;
    public String name;
    public List<String> desc = new  ArrayList<>();
    public List<String> exits = new ArrayList<>();
    public Room(int x)
    {

        number = x;

    }
}
