package algorithm.ljh.ex;

import java.util.Arrays;

public class Fruit
{
    public static void main(String[] args)
    {
        Fruit[] fruits = new Fruit[4];
        
        fruits[0] = new Fruit("Pineapple", 70);
        fruits[1] = new Fruit("Apple", 100);
        fruits[2] = new Fruit("Orange", 80);
        fruits[3] = new Fruit("Banana", 90);
        
        Arrays.sort(fruits);
        
    }
    
    public String name;
    
    public int quantity;
    
    public Fruit(String name, int quantity)
    {
        
        this.name = name;
        
        this.quantity = quantity;
        
    }
    
    @Override
    public String toString()
    {
        return "[ 과일이름 : " + this.name + " , 잔여 수량 : " + this.quantity + " ]";
    }
}