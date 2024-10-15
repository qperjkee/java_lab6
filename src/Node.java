/**
 * Represents a node in a doubly linked list. Each node contains a value and references
 * to the previous and next nodes in the list.
 *
 * @param <T> the type of the value stored in the node
 */
public class Node<T> {
    /** The value stored in this node. */
    T value;

    /** The reference to the previous node in the list. */
    Node<T> prev;

    /** The reference to the next node in the list. */
    Node<T> next;

    /**
     * Constructs a new Node with the specified value.
     *
     * @param value the value to store in the node
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Returns the value stored in this node.
     *
     * @return the value stored in this node
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value stored in this node.
     *
     * @param value the new value to store in this node
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Returns the reference to the previous node in the list.
     *
     * @return the previous node in the list, or null if there is no previous node
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Sets the reference to the previous node in the list.
     *
     * @param prev the new previous node in the list
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Returns the reference to the next node in the list.
     *
     * @return the next node in the list, or null if there is no next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node in the list.
     *
     * @param next the new next node in the list
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}