package algorithm.jjw.ex;

import java.util.Arrays;
import java.util.Comparator;



// 1. 자연정렬 Comparable<Type>
// 2. 사용자 임의 정렬 Comparator<Type>
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
        
        for(Fruit fr : fruits)
            System.out.println(fr);
        
    }
    
    public String name;
    
    public int quantity;
    
    public Fruit(String name, int quantity)
    {
        
        this.name = name;
        
        this.quantity = quantity;
        
    }
    
    //이름 정렬
    Comparator<Fruit> nameComp = new Comparator<Fruit>() {

		@Override
		public int compare(Fruit o1, Fruit o2) {
			// TODO Auto-generated method stub
			return o1.name.compareTo(o2.name);
		}
    	
	};
    
	Comparator<Fruit> quantityComp = new Comparator<Fruit>() {

		@Override
		public int compare(Fruit o1, Fruit o2) {
			// TODO Auto-generated method stub
			return o2.name.compareTo(o1.name);
		}
		
	};
    
    
    
    @Override
    public String toString()
    {
        return "[ 과일이름 : " + this.name + " , 잔여 수량 : " + this.quantity + " ]";
    }
}