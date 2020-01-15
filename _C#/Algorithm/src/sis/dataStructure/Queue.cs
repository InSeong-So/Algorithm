using System;

namespace Algorithm
{
    public class Queue
    {
        // 가장 먼저 삽입된 데이터의 위치
        private Node front;

        // 가장 마지막에 삽입된 데이터의 위치
        private Node back;

        private int size = 0;

        private class Node
        {   
            // 데이터
            public Object data;

            // 다음 데이터를 암시하는 포인터
            public Node next;

            public Node(Object input)
            {
                this.data = input;
                this.next = null;
            }
        }

        // 최근에 삽입된 데이터의 앞에 새로운 데이터를 추가
        public void enqueue(Object input)
        {
            Node newNode = new Node(input);
            if (back != null)
            {
                back.next = newNode;
            }
            back = newNode;
            if (front == null)
            {
                front = back;
            }

            size++;
        }

        // 가장 최근의 데이터를 출력
        public Object dequeue()
        {
            if (front == null)
            {
                throw new InvalidOperationException();
            }

            Object data = front.data;
            front = front.next;

            if (front == null)
            {
                back = null;
            }

            size--;

            return data;
        }


        // 가장 먼저 삽입된 데이터 확인
        public Object peek()
        {
            if (front == null)
            {
                throw new InvalidOperationException();
            }
            return front.data;
        }

        // 데이터가 비어있는지 확인
        public bool isEmpty()
        {
            return front == null;
        }
    }
}
