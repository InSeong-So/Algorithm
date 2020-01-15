package algorithm.sis.ex.compare_Impl;

import java.util.Arrays;

public class Fruit2 implements Comparable<Fruit2>
{
    public static void main(String[] args)
    {
        Fruit2[] fruits = new Fruit2[4];
        
        fruits[0] = new Fruit2("Pineapple", 70);
        fruits[1] = new Fruit2("Apple", 100);
        fruits[2] = new Fruit2("Orange", 80);
        fruits[3] = new Fruit2("Banana", 90);
        
        Arrays.sort(fruits);
        
        for(Fruit2 fr : fruits)
            System.out.println(fr);
    }
    
    public String name;
    
    public int quantity;
    
    public Fruit2(String name, int quantity)
    {
        
        this.name = name;
        
        this.quantity = quantity;
        
    }
    
    @Override
    public int compareTo(Fruit2 o)
    {
        return name.compareTo(o.name);
    }

    @Override
    public String toString()
    {
        return "[ 과일이름 : " + this.name + " , 잔여 수량 : " + this.quantity + " ]";
    }
    
}