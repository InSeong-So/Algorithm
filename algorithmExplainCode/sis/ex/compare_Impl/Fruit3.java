import java.util.Arrays;
import java.util.Comparator;

public class Fruit3
{
    public static void main(String[] args)
    {
        Fruit3[] fruits = new Fruit3[4];
        
        fruits[0] = new Fruit3("Pineapple", 70);
        fruits[1] = new Fruit3("Apple", 100);
        fruits[2] = new Fruit3("Orange", 80);
        fruits[3] = new Fruit3("Banana", 90);
        
        Arrays.sort(fruits, nameComparator);
        // OR
        Arrays.sort(fruits, quantityComparator);
        
    }
    
    public String name;
    
    public int quantity;
    
    public Fruit3(String name, int quantity)
    {
        
        this.name = name;
        
        this.quantity = quantity;
        
    }
    
    public static Comparator<Fruit3> nameComparator = new Comparator<Fruit3>() {
        
        @Override
        public int compare(Fruit3 o1, Fruit3 o2)
        {
            return o1.name.compareTo(o1.name);
        }
    };
    
    public static Comparator<Fruit3> quantityComparator = new Comparator<Fruit3>() {
        
        @Override
        public int compare(Fruit3 o1, Fruit3 o2)
        {
            return o1.quantity - o2.quantity;
        }
    };
    
}