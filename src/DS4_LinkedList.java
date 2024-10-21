public class DS4_LinkedList<E> implements DS4_LinkedList_Interface<E>
{
    private DS4_LinkedList_Node<E> listNode;
    private DS4_LinkedList_Node<E> lastNode;
    public DS4_LinkedList(E data)
    {
        listNode = new DS4_LinkedList_Node<E>(data);
    }
    public DS4_LinkedList()
    {
        listNode = null;
    }
    public DS4_LinkedList_Node<E> getFirstNode()
    {
        return listNode;
    }
    public DS4_LinkedList_Node<E> getLastNode()
    {
        DS4_LinkedList_Node<E> temp = listNode;
        while(temp.getNext() != null)
        {
            temp = temp.getNext();
        }
        return temp;
    }
    public E getFirst()
    {
        return get(0);
    }
    public E getLast()
    {
        return get(size()-1);
    }
    public E removeFirst()
    {
        return remove(0);
    }
    public E removeLast()
    {
        return remove(size()-1);
    }
    public void addFirst(E data)
    {
        DS4_LinkedList_Node<E> newNode = new DS4_LinkedList_Node<E>(data);
        newNode.setNext(listNode);
        listNode = newNode;
    }
    public void addLast(E data)
    {
        DS4_LinkedList_Node<E> newNode = new DS4_LinkedList_Node<E>(data);
        if(listNode == null)
        {
            listNode = newNode;
        }
        else
        {
            DS4_LinkedList_Node<E> temp = listNode;
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }
    public void clear()
    {
        listNode = null;
    }
    public int size()
    {
        DS4_LinkedList_Node<E> temp = listNode;
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
        DS4_LinkedList_Node<E> temp = listNode;
        for(int i = 0; i < x; i++)
        {
            temp = temp.getNext();
        }
        return temp.getData();
    }
    public void add(int x, E data)
    {
        DS4_LinkedList_Node<E> temp = listNode;
        for(int i = 0; i < x; i++)
        {
            temp = temp.getNext();
        }
        DS4_LinkedList_Node<E> newNode = new DS4_LinkedList_Node<E>(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }
    public E remove(int x)
    {
        DS4_LinkedList_Node<E> temp = listNode;
        for(int i = 0; i < x; i++)
        {
            temp = temp.getNext();
        }
        E oldData = temp.getData();
        temp.setData(null);
        return oldData;
    }
    public E set(int x, E data)
    {
        DS4_LinkedList_Node<E> temp = listNode;
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
        return listNode == null && lastNode == null;
    }
    public String toString()
    {
        DS4_LinkedList_Node<E> temp = listNode;
        String result = "[";
        DS4_LinkedList_Node<E> lastNode = getLastNode();
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
