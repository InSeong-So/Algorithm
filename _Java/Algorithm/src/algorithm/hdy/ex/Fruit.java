package algorithm.hdy.ex;

import java.util.Arrays;
import java.util.Comparator;

// 1. 자연 정렬  implements Comparable<Fruit>

// 2. 사용자 임의 정렬 Comparator<T> 익명 클래스 구현 
public class Fruit implements Comparable<Fruit>
{
    public static void main(String[] args)
    {
        Fruit[] fruits = new Fruit[4];
        
        fruits[0] = new Fruit("Pineapple", 70);
        fruits[1] = new Fruit("Apple", 100);
        fruits[2] = new Fruit("Orange", 80);
        fruits[3] = new Fruit("Banana", 90);
        
        Arrays.sort(fruits, nameCamp);
        System.out.println(Arrays.toString(fruits));
        
        Arrays.sort(fruits, quanCamp);
        System.out.println(Arrays.toString(fruits));
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

	@Override
	public int compareTo(Fruit fruit) {
		return name.compareTo(fruit.name);
	}
    
    static Comparator<Fruit> nameCamp = new Comparator<Fruit>() {

		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o1.name.compareTo(o2.name);
		}
    	
	};
	
	static Comparator<Fruit> quanCamp = new Comparator<Fruit>() {

		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o1.quantity - o2.quantity;
		}
    	
	};
    
}