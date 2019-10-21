package practice.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수
{
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int count = 0;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String str : participant){
            if(map.get(str) == null){
                map.put(str, 1);
            } else {
                count = map.get(str) + 1;
                map.put(str, count);
            }
        }
        for(String str : completion){
            count = map.get(str) -1;
            map.put(str, count);
        }
        
        for(String str : participant){
            if(map.get(str) != 0){
                answer = str;
            }
        }
        
        return answer;
    }
}
