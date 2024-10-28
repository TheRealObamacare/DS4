public class DS4_LinkedList<E> implements DS4_LinkedList_Interface<E>
{
    private DS4_LinkedList_Node<E> firstNode;
    private DS4_LinkedList_Node<E> lastNode;
    public DS4_LinkedList(E data)
    {
        lastNode = firstNode = new DS4_LinkedList_Node<>(data);
    }
    public DS4_LinkedList()
    {
        lastNode = firstNode = null;
    }
    public DS4_LinkedList_Node<E> getFirstNode()
    {
        return firstNode;
    }
    public DS4_LinkedList_Node<E> getLastNode()
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
        DS4_LinkedList_Node<E> temp = firstNode;
        firstNode = firstNode.getNext();
        return temp.getData();
    }
    public E removeLast()
    {
        if (firstNode == lastNode) {
            E oldData = lastNode.getData();
            lastNode = firstNode = null;
            return oldData;
        }
        DS4_LinkedList_Node<E> temp = firstNode;
        while(temp.getNext() != lastNode)
        {
            temp = temp.getNext();
        }
        E oldData = lastNode.getData();
        lastNode = temp;
        lastNode.setNext(null);
        return oldData;
    }
    public void addFirst(E data)
    {
        if (firstNode == null)
        {
            firstNode = new DS4_LinkedList_Node<>(data);
            lastNode = firstNode;
            return;
        }
        DS4_LinkedList_Node<E> newNode = new DS4_LinkedList_Node<>(data);
        newNode.setNext(firstNode);
        firstNode = newNode;
    }

    public void addLast(E data)
    {

        DS4_LinkedList_Node<E> newNode = new DS4_LinkedList_Node<>(data);
        if(isEmpty())
        {
            firstNode = newNode;
            lastNode = firstNode;
        }
        else
        {
            DS4_LinkedList_Node<E> temp = lastNode;
            lastNode = newNode;
            temp.setNext(lastNode);
        }
    }
    public void clear()
    {
        firstNode = null;
        lastNode = null;
    }
    public int size()
    {
        DS4_LinkedList_Node<E> temp = firstNode;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
    public E get(int x)
    {
        DS4_LinkedList_Node<E> temp = firstNode;
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
        DS4_LinkedList_Node<E> temp = firstNode;
        for (int i = 0; i < x - 1; i++) {
            temp = temp.getNext();
        }
        DS4_LinkedList_Node<E> newNode = new DS4_LinkedList_Node<>(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
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
            DS4_LinkedList_Node<E> temp = firstNode.getNext();
            DS4_LinkedList_Node<E> temp1 = firstNode;
            for(int i = 0; i < x-1; i++)
            {
                temp = temp.getNext();
                temp1 = temp1.getNext();
            }
            E oldData = temp.getData();
            temp1.setNext(temp.getNext());
            return oldData;
        }
    }
    public E set(int x, E data)
    {
        DS4_LinkedList_Node<E> temp = firstNode;
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
    public String toString()
    {
        DS4_LinkedList_Node<E> temp = firstNode;
        String result = "[";
        while(temp != null)
        {
            result += temp.getData();
            if(temp != lastNode)
            {
                result += ", ";
            }
            temp = temp.getNext();
        }
        return result+"]";
    }
}
