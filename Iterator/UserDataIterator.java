package Iterator;

import java.util.ArrayList;

public class UserDataIterator implements UserIterator {

    private ArrayList<ArrayList<String>> users;
    private int index = 0;

    public UserDataIterator(ArrayList<ArrayList<String>> users) {
        this.users = users;
    }

    public boolean hasNext() {
        return index < users.size() - 1;
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public String[] next() {
        return users.get(++index).toArray(new String[0]);
    }

    public String[] previous() {
        return users.get(--index).toArray(new String[0]);
    }
}
