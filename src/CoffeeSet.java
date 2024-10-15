import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * A custom implementation of a {@link Set} interface for {@link Coffee} objects using
 * a doubly linked list as the internal structure.
 */
public class CoffeeSet implements Set<Coffee> {
    /** The head (first) node of the list. */
    private Node<Coffee> head;

    /** The tail (last) node of the list. */
    private Node<Coffee> tail;

    /** The number of elements in the set. */
    private int size;

    /**
     * Constructs an empty {@code CoffeeSet}.
     */
    public CoffeeSet() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructs a {@code CoffeeSet} with a single {@code Coffee} element.
     *
     * @param coffee the coffee element to add to the set
     */
    public CoffeeSet(Coffee coffee) {
        this();
        add(coffee);
    }

    /**
     * Constructs a {@code CoffeeSet} and adds all elements from the specified collection.
     *
     * @param coffees the collection of coffee elements to add
     */
    public CoffeeSet(Collection<? extends Coffee> coffees) {
        this();
        addAll(coffees);
    }

    /**
     * Adds a {@code Coffee} element to the set.
     *
     * @param coffee the coffee element to be added
     * @return {@code true} if the element was added successfully; {@code false} if the element already exists
     */
    @Override
    public boolean add(Coffee coffee) {
        if (contains(coffee)) {
            return false;
        }

        Node<Coffee> newNode = new Node<>(coffee);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes the specified object from the set if it is present.
     *
     * @param o the object to be removed
     * @return {@code true} if the object was removed; {@code false} otherwise
     */
    @Override
    public boolean remove(Object o) {
        Node<Coffee> current = head;
        while (current != null) {
            if (current.getValue().equals(o)) {
                if (current == head) {
                    head = current.getNext();
                }
                if (current == tail) {
                    tail = current.getPrev();
                }
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                }
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Checks if the set contains the specified object.
     *
     * @param o the object to check for
     * @return {@code true} if the object is present; {@code false} otherwise
     */
    @Override
    public boolean contains(Object o) {
        Node<Coffee> current = head;
        while (current != null) {
            if (current.getValue().equals(o)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the set is empty.
     *
     * @return {@code true} if the set is empty; {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in the set.
     *
     * @return an iterator over the elements in the set
     */
    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<>() {
            private Node<Coffee> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Coffee next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Coffee coffee = current.getValue();
                current = current.getNext();
                return coffee;
            }
        };
    }

    /**
     * Removes all elements from the set.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks if the set contains all elements from the specified collection.
     *
     * @param c the collection to check
     * @return {@code true} if all elements are present; {@code false} otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements from the specified collection to the set.
     *
     * @param c the collection of elements to add
     * @return {@code true} if any elements were added; {@code false} otherwise
     */
    @Override
    public boolean addAll(Collection<? extends Coffee> c) {
        boolean changed = false;
        for (Coffee coffee : c) {
            if (add(coffee)) {
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Removes all elements from the specified collection from the set.
     *
     * @param c the collection of elements to remove
     * @return {@code true} if any elements were removed; {@code false} otherwise
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object o : c) {
            if (remove(o)) {
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Retains only the elements in the set that are contained in the specified collection.
     *
     * @param c the collection of elements to retain
     * @return {@code true} if any elements were removed; {@code false} otherwise
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        Node<Coffee> current = head;
        while (current != null) {
            if (!c.contains(current.getValue())) {
                Node<Coffee> next = current.getNext();
                remove(current.getValue());
                current = next;
                changed = true;
            } else {
                current = current.getNext();
            }
        }
        return changed;
    }

    /**
     * Returns an array containing all elements in the set.
     *
     * @return an array containing all elements in the set
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node<Coffee> current = head;
        while (current != null) {
            array[index++] = current.getValue();
            current = current.getNext();
        }
        return array;
    }

    /**
     * Returns an array containing all elements in the set, using the specified array
     * if it is large enough, or allocating a new array otherwise.
     *
     * @param a the array into which the elements will be stored
     * @param <T> the type of the array elements
     * @return an array containing all elements in the set
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) new Object[size];
        }
        int index = 0;
        Node<Coffee> current = head;
        while (current != null) {
            a[index++] = (T) current.getValue();
            current = current.getNext();
        }
        return a;
    }
}