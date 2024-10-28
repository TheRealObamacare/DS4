public class DS4_Doubly_Circular_LinkedList<E>  implements DS4_Doubly_Circular_LinkedList_Interface<E>
{
    private DS4_Doubly_Circular_LinkedList_Node<E> head;
    private DS4_Doubly_Circular_LinkedList_Node<E> tail;
    private int size;
    public DS4_Doubly_Circular_LinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    public DS4_Doubly_Circular_LinkedList_Node<E> getFirstNode()
    {
        return head;
    }

    public DS4_Doubly_Circular_LinkedList_Node<E> getLastNode()
    {
        return tail;
    }

    public E getFirst()
    {
        return head.getData();
    }
    public E getLast()
    {
        return tail.getData();
    }

    public E removeFirst();

    public E removeLast();

    public void addFirst(E data);

    public void addLast(E data);

    public void clear();

    public int size();

    public E get(int x);

    public void add(int x, E data);

    public E remove(int x);

    public E set(int x, E data);

    public boolean isEmpty();

    public String backwardsToString();
}
