package practice.programmers.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class 다리를지나는트럭 {
    int weight;
    int distance;
    
    public 다리를지나는트럭(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }
     
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int time = 0;
            int weightLeft = weight;
            다리를지나는트럭 truck = null;
            
            Queue<다리를지나는트럭> outside = new LinkedList<다리를지나는트럭>();
            List<다리를지나는트럭> inside = new ArrayList<다리를지나는트럭>();
     
            for (int t : truck_weights) {
                outside.add(new 다리를지나는트럭(t, bridge_length));
            }
     
            while (!(inside.isEmpty()&&outside.isEmpty())) {
                time++;
                
                if (!inside.isEmpty() && inside.get(0).distance <= 0) {
                    weightLeft += inside.get(0).weight;
                    inside.remove(0);
                }
                
                if (!outside.isEmpty() && weightLeft - outside.peek().weight >= 0) {
                    weightLeft -= outside.peek().weight;
                    inside.add(outside.poll());
                }
                
                for (int i = 0; i < inside.size(); i++) {
                    truck = inside.get(i);
                    truck.distance--;
                }
            }
            return time;
        }
    }
}

class Solution2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
            Stack<Integer> truckStack = new Stack<>();
            Map<Integer, Integer> bridgeMap = new HashMap<>();

            for (int i = truck_weights.length-1; i >= 0; i--)
                truckStack.push(truck_weights[i]);

            int answer = 0;
            int sum = 0;
            while(true) {
                answer++;

                if (bridgeMap.containsKey(answer))
                    bridgeMap.remove(answer);

                sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

                if (!truckStack.isEmpty())
                    if (sum + truckStack.peek() <= weight)
                        bridgeMap.put(answer + bridge_length, truckStack.pop());

                if (bridgeMap.isEmpty() && truckStack.isEmpty())
                    break;
            }
            return answer;
    }
}