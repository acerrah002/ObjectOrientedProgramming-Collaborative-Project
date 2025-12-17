package Iterator;

// Goal: Encapsulate user traversal logic instead of manual index management.

public interface UserIterator {
    boolean hasNext();
    boolean hasPrevious();
    String[] next();
    String[] previous();
}

