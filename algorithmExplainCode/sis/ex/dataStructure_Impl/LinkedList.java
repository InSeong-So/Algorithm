public class LinkedList<T>
{
    
    private Node head;
    
    private Node tail;
    
    private int size = 0;
    
    private class Node
    {
        private Object data;
        
        private Node next;
        
        public Node(Object input)
        {
            this.data = input;
            this.next = null;
        }
        
        public String toString()
        {
            return String.valueOf(this.data);
        }
    }
    
    public void addFirst(Object input)
    {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null)
        {
            tail = head;
        }
    }
    
    public void addLast(Object input)
    {
        Node newNode = new Node(input);
        if (size == 0)
        {
            addFirst(input);
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    
    // 내부적인 부품이 외부에 노출되면 안됨
    Node node(int index)
    {
        Node x = head;
        for (int i = 0; i < index; i++)
        {
            x = x.next;
        }
        return x;
    }
    
    public void add(int index, Object input)
    {
        if (index == 0)
        {
            addFirst(input);
        }
        else
        {
            Node temp1 = node(index - 1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if (newNode.next == null)
            {
                tail = newNode;
            }
        }
    }
    
    public String toString()
    {
        if (head == null)
        {
            return "[]";
        }
        
        Node temp = head;
        String str = "[";
        
        while (temp.next != null)
        {
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;
        
        return str + "]";
    }
    
    public Object removeFirst()
    {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }
    
    public Object remove(int index)
    {
        if (index == 0)
        {
            return removeFirst();
        }
        Node temp = node(index - 1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        Object returnData = todoDeleted.data;
        if (todoDeleted == tail)
        {
            tail = temp;
        }
        size--;
        return returnData;
    }
    
    public Object removeLast()
    {
        return remove(size - 1);
    }
    
    public int size()
    {
        return size;
    }
    
    public Object get(int index)
    {
        Node temp = node(index);
        return temp.data;
    }
    
    public int indexOf(Object input)
    {
        Node temp = head;
        int index = 0;
        while (temp.data != input)
        {
            temp = temp.next;
            index++;
            if (temp == null)
            {
                return -1;
            }
        }
        return index;
    }
    
    // 중복되고 정렬되지 않은 링크드 리스트를 정렬시키고 중복을 제거하기
    // 고정된 포인터 방법, 시간은 더 많이 들지만 공간 효율성이 좋다.
    public void removeDups()
    {
        Node newNode = head;
        while (newNode == null && newNode.next != null)
        {
            Node runner = newNode;
            while (runner.next != null)
            {
                if (newNode.data == runner.next.data)
                {
                    runner.next = runner.next.next;
                }
                else
                {
                    runner = runner.next;
                }
            }
            newNode = newNode.next;
        }
    }
}