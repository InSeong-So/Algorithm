using System;

namespace Algorithm
{
    public class Stack
    {
        // 가장 마지막에 삽입된 데이터의 위치를 가리키는 포인터
        private Node top;
        
        // 스택의 크기
        private int size = 0;
        
        // 데이터를 암시하는 클래스
        private class Node
        {
            // 데이터
            public Object data;
            
            // 다음 데이터를 암시하는 포인터
            public Node next;
            
            // 생성자, 처음 생성 시 스택의 데이터는 하나, 다음 데이터는 존재하지 않음
            public Node(Object input)
            {
                this.data = input;
                this.next = null;
            }
        }
        
        // 가장 마지막의 데이터를 출력
        public Object pop()
        {
            if (top == null)
            {
                throw new InvalidOperationException();
            }
            Object item = top.data;
            top = top.next;
            size--;
            return item;
        }
        
        // 데이터를 추가
        public void push(Object input)
        {
            Node newNode = new Node(input);
            newNode.next = top;
            top = newNode;
            size++;
        }
        
        // 가장 마지막에 있는 데이터를 확인
        public Object peek()
        {
            if (top == null)
            {
                throw new InvalidOperationException();
            }
            
            return top.data;
        }
        
        // 데이터가 비어있는지 확인
        public bool isEmpty()
        {
            return top == null;
        }
    }
}
