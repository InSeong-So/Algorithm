package practice;

import practice.programmers.hash.완주하지못한선수;

// Solution 실행 스레드
public class Main
{
    
    public static void main(String[] args)
    {
        String[] first = {"mislav", "stanko", "mislav", "ana"};
        String[] two = {"stanko", "ana", "mislav"};
        
        System.out.println(완주하지못한선수.solution(first, two));
    }
}
