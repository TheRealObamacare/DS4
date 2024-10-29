public class DS4_Doubly_Circular_LinkedList<E>  implements DS4_Doubly_Circular_LinkedList_Interface<E>
{
    private DS4_Doubly_Circular_LinkedList_Node<E> firstNode;
    private DS4_Doubly_Circular_LinkedList_Node<E> lastNode;
    public DS4_Doubly_Circular_LinkedList(E data)
    {
        lastNode = firstNode = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        firstNode.setNext(lastNode);
        firstNode.setPrev(lastNode);
        lastNode.setNext(firstNode);
        lastNode.setPrev(firstNode);
    }
    public DS4_Doubly_Circular_LinkedList()
    {
        lastNode = firstNode = null;
    }
    public DS4_Doubly_Circular_LinkedList_Node<E> getFirstNode()
    {
        return firstNode;
    }

    public DS4_Doubly_Circular_LinkedList_Node<E> getLastNode()
    {
        return lastNode;
    }

    public E getFirst()
    {
        return firstNode.getData();
    }

    public E getLast()
    {
        return lastNode.getData();
    }

    public E removeFirst()
    {
        if (firstNode == lastNode) {
            E oldData = firstNode.getData();
            lastNode = firstNode = null;
            return oldData;
        }
        DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode;
        firstNode = firstNode.getNext();
        firstNode.setPrev(lastNode);
        lastNode.setNext(firstNode);
        return temp.getData();
    }

    public E removeLast(){
        if (firstNode == lastNode) {
            E oldData = lastNode.getData();
            lastNode = firstNode = null;
            return oldData;
        }
        DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode;
        while(temp.getNext() != lastNode)
        {
            temp = temp.getNext();
        }
        E oldData = lastNode.getData();
        lastNode = temp;
        lastNode.setNext(firstNode);
        return oldData;
    }

    public void addFirst(E data)
    {
        if (firstNode == null)
        {
            firstNode = new DS4_Doubly_Circular_LinkedList_Node<>(data);
            lastNode = firstNode;
            return;
        }
        DS4_Doubly_Circular_LinkedList_Node<E> newNode = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        newNode.setNext(firstNode);
        firstNode = newNode;
        lastNode.setNext(firstNode);
        firstNode.setPrev(lastNode);
    }

    public void addLast(E data)
    {
        DS4_Doubly_Circular_LinkedList_Node<E> newNode = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if(isEmpty())
        {
            lastNode = firstNode = newNode;
        }
        else
        {
            DS4_Doubly_Circular_LinkedList_Node<E> temp = lastNode;
            lastNode = newNode;
            temp.setNext(lastNode);
            lastNode.setPrev(temp);
            lastNode.setNext(firstNode);
            firstNode.setPrev(lastNode);
        }
    }

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    }

    public int size()
    {
        if (isEmpty())
        {
            return 0;
        }
        int count = 1;
        DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode;
        while(temp.getNext() != firstNode)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public E get(int x)
    {
        DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode;
        for(int i = 0; i < x; i++)
        {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public void add(int x, E data)
    {
        if (x == 0) {
            addFirst(data);
            return;
        }
        else if (x == size()) {
            addLast(data);
            return;
        }
        DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode;
        for (int i = 0; i < x - 1; i++) {
            temp = temp.getNext();
        }
        DS4_Doubly_Circular_LinkedList_Node<E> newNode = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        newNode.setPrev(temp);
        newNode.getNext().setPrev(newNode);
    }

    public E remove(int x)
    {
        if (x == 0) {
            return removeFirst();
        }
        else if (x == size() - 1) {
            return removeLast();
        }
        else
        {
            DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode.getNext();
            DS4_Doubly_Circular_LinkedList_Node<E> temp1 = firstNode;
            for(int i = 0; i < x-1; i++)
            {
                temp = temp.getNext();
                temp1 = temp1.getNext();
            }
            E oldData = temp.getData();
            temp1.setNext(temp.getNext());
            temp.getNext().setPrev(temp1);
            return oldData;
        }
    }

    public E set(int x, E data)
    {
        DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode;
        for(int i = 0; i < x; i++)
        {
            temp = temp.getNext();
        }
        E oldData = temp.getData();
        temp.setData(data);
        return oldData;
    }

    public boolean isEmpty()
    {
        return firstNode == null && lastNode == null;
    }

    public String backwardsToString()
    {
        DS4_Doubly_Circular_LinkedList_Node<E> temp = lastNode;
        String result = "[";
        while(temp != firstNode)
        {
            result += temp.getData() + ", ";
            temp = temp.getPrev();
        }
        result += temp.getData() + "]";
        return result;
    }
    public String toString()
    {
        DS4_Doubly_Circular_LinkedList_Node<E> temp = firstNode;
        String result = "[";
        while(temp != lastNode)
        {
            result += temp.getData() + ", ";
            temp = temp.getNext();
        }
        result += temp.getData() + "]";
        return result;
    }
}
