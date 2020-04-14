package questions.chap02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * - 2.1 중복 없애기
 * - 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라.
 */
public class two01
{
    
    void deleteDups(LinkedListNode n)
    {
        
        Set<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null)
        {
            if (set.contains(n.data))
            {
                previous.next = n.next;
            }
            else
            {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
}

class LinkedListNode extends LinkedList
{
    LinkedListNode next = null;
    
    int data;
    
    public LinkedListNode(int data)
    {
        this.data = data;
    }
    
    void appendToTail(int data)
    {
        LinkedListNode end = new LinkedListNode(data);
        LinkedListNode n = this;
        while (n.next != null)
        {
            n = n.next;
        }
        n.next = end;
    }
}