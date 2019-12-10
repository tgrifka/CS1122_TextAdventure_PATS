package world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import parser.Objection;

public class Room {

    private String description;
    private String title;
    private HashMap<Direction, Room> connections = new HashMap<>();
    private ObjectionComponent objections = new ObjectionComponent();

    public String look() {
        StringBuilder fullDescription = new StringBuilder();

        fullDescription.append("--- ");
        fullDescription.append(getTitle());
        fullDescription.append(" ---\n");

        fullDescription.append(getDescription());

        if( connections.size() == 0) {
            
        } else if( connections.size() == 1 ) { 
            fullDescription.append("\n\nThere is an exit ");
            fullDescription.append(connections.keySet().toArray(new Direction[]{})[0].getName());
            fullDescription.append(".");
        } else {
            fullDescription.append("\n\nThere are exits ");

            Iterator<Direction> iterator = connections.keySet().iterator();
            fullDescription.append(iterator.next().getName());

            for(int i = 1; i < connections.size() - 1; ++i ) {
                fullDescription.append(", ");
                fullDescription.append(iterator.next().getName());
            }
            if( connections.size() == 2 ) {
                fullDescription.append(" and ");
            } else {
                fullDescription.append(", and ");
            }
            fullDescription.append(iterator.next().getName());
            fullDescription.append(".");
        }

        /* Here, add a description of the items present in the room */

        fullDescription.append("\n");
        return fullDescription.toString();
    }

    public ObjectionComponent getObjectionComponent() {
        return objections;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Room getConnection(Direction dir) {
        return connections.get(dir);
    }

    public Direction[] getConnectionDirs() {
        return connections.keySet().toArray(new Direction[]{});
    }

    public boolean addConnection(Direction dir, Room room) {
        return connections.put(dir, room) != null;
    }

    public boolean removeConnection(Direction dir) {
        return connections.remove(dir) != null;
    }
}
