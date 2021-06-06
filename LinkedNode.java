/**
 * LinkedNode class that represents a single Node in a linked structure.
 *
 * @param <T> Generic type parameter
 * @author Elijah Freeman (elijahff@uw.edu)
 * @version 1.0 (3 February 2020)
 */
public class LinkedNode<T> {

    /**Reference to the next node in the list.*/
    private LinkedNode<T> next;
    /**Reference to the element to be stored in the list.*/
    private T element;

    /**Contructor that creates an empty Node.*/
    public LinkedNode() {
       this(null);
    }

    /**Constructor that creates a node that stores T element.*/
    public LinkedNode(T element) {
        next = null;
        this.element = element;
    }

    /**
     * Returns the next node in the list.
     * @return next next node after this node.
     */
    public LinkedNode<T> getNext() {
        return next;
    }

    /**
     * Sets a link to the next node.
     * @param node next node after this one.
     */
    public void setNext(LinkedNode<T> node) {
        next = node;
    }

    /**
     * Returns the element that is being stored in this node.
     * @return element element that is stored in node.
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element that is stored in this node.
     * @param element element to be stored in node.
     */
    public void setElement(T element) {
        this.element = element;
    }
}
