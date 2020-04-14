import java.util.NoSuchElementException;

public class Queue<T>
{
    // 가장 먼저 삽입된 데이터의 위치
    private Node<T> front;
    
    // 가장 마지막에 삽입된 데이터의 위치
    private Node<T> rear;
    //  private int size;
    //  private Object[] queueArray;
    
    // 데이터를 암시하는 클래스
    private class Node<T>
    {
        // 데이터
        private T data;
        
     // 다음 데이터를 암시하는 포인터
        private Node<T> next;
        
        public Node(T data)
        {
            this.data = data;
        }
    }
    
    // 최근에 삽입된 데이터의 앞에 새로운 데이터를 추가
    public void add(T input)
    {
        Node<T> newNode = new Node<T>(input);
        if (rear != null)
        {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null)
        {
            front = rear;
        }
    }
    
    // 가장 최근의 데이터를 삭제
    public T remove()
    {
        if (front == null)
        {
            throw new NoSuchElementException();
        }
        
        T data = front.data;
        front = front.next;
        
        if (front == null)
        {
            rear = null;
        }
        
        return data;
    }
    
    // 가장 먼저 삽입된 데이터 확인
    public T peek()
    {
        if (front == null)
        {
            throw new NoSuchElementException();
        }
        return front.data;
    }
    
    // 데이터가 비어있는지 확인
    public boolean isEmpty()
    {
        return front == null;
    }
}