using System;
using System.Collections.Generic;

namespace Algorithm
{
    public class _Fruit2
    {
        public static void Main(string[] args)
        {
            _Fruit2[] fruits = new _Fruit2[4];

            fruits[0] = new _Fruit2("Pineapple", 70);
            fruits[1] = new _Fruit2("Apple", 100);
            fruits[2] = new _Fruit2("Orange", 80);
            fruits[3] = new _Fruit2("Banana", 90);

            Array.Sort(fruits, new nameComparer());

            foreach (_Fruit2 member in fruits)
            {
                Console.WriteLine(member);
            }
        }

        public String name;
        public int quantity;

        public _Fruit2(String name, int quantity)
        {
            this.name = name;
            this.quantity = quantity;
        }

        public override string ToString()
        {
            return string.Format("과일이름:{0}, 잔여 수량:{1}", name, quantity);
        }

        public class nameComparer : Comparer<_Fruit2>
        {
            public override int Compare(_Fruit2 o1, _Fruit2 o2)
            {
                return String.Compare(o1.name, o2.name);
            }
        }

        public class quantityComparer : Comparer<_Fruit2>
        {
            public override int Compare(_Fruit2 o1, _Fruit2 o2)
            {
                return o1.quantity - o2.quantity;
            }
        }
    }
}
