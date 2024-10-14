import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class CoffeeSet implements Set<Coffee> {
    private Node<Coffee> head;
    private Node<Coffee> tail;
    private int size;

    public CoffeeSet() {
        head = null;
        tail = null;
        size = 0;
    }

    public CoffeeSet(Coffee coffee) {
        this();
        add(coffee);
    }

    public CoffeeSet(Collection<? extends Coffee> coffees) {
        this();
        addAll(coffees);
    }

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

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