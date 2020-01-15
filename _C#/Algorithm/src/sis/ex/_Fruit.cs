using System;
using System.Collections.Generic;

namespace Algorithm
{
    public class _Fruit : IComparable<_Fruit>
    {
        public static void Main(string[] args)
        {
            _Fruit[] fruits = new _Fruit[4];

            fruits[0] = new _Fruit("Pineapple", 70);
            fruits[1] = new _Fruit("Apple", 100);
            fruits[2] = new _Fruit("Orange", 80);
            fruits[3] = new _Fruit("Banana", 90);

            Array.Sort(fruits);

            foreach (_Fruit member in fruits)
            {
                Console.WriteLine(member);
            }
        }

        public String name;
        public int quantity;

        public _Fruit(String name, int quantity)
        {
            this.name = name;
            this.quantity = quantity;
        }

        public override string ToString()
        {
            return string.Format("과일이름:{0}, 잔여 수량:{1}", name, quantity);
        }

        public int CompareTo(_Fruit o)
        {
            return name.CompareTo(o.name);
        }
    }
}
