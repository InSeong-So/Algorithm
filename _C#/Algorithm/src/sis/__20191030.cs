using System;
using System.Collections.Generic;

namespace Algorithm
{
    public class __20191030
    {
        public void solution1(int[] n)
        {
            int maxNum = 0;
            int minNum = 0;

            for (int i = 0; i < n.Length; i++)
            {
                if (i == 0)
                {
                    maxNum = n[i];
                    minNum = n[i];
                }

                if (maxNum < n[i])
                {
                    maxNum = n[i];
                }
                else if (minNum > n[i])
                {
                    minNum = n[i];
                }
            }

            Console.WriteLine("최댓값은 : " + maxNum);
            Console.WriteLine("최솟값은 : " + minNum);
        }

        public void solution2(int n)
        {
            int sumValue = 0;
            int tempValue = 1;

            for (int i = 0; i < 10; i++)
            {
                sumValue = i + tempValue;
                tempValue = sumValue;
            }

            Console.WriteLine(n + "번째 항까지의 합 : " + sumValue);
        }

        public void solution3(int n)
        {
            int sumValue = 0;

            for (int i = 1; i <= n; i++)
            {
                if (i % 2 == 0)
                {
                    sumValue += (i * -1);
                }
                else
                {
                    sumValue += i;

                }

                Console.WriteLine(i + "번째 : " + sumValue);
            }

            Console.WriteLine("총합 : " + sumValue);
        }

        public void solution4(int[] n)
        {
            int temp = 0;

            for (int i = 0; i < n.Length; i++)
            {
                for (int j = i + 1; j < n.Length; j++)
                {
                    if (n[i] > n[j])
                    {
                        temp = n[j];
                        n[j] = n[i];
                        n[i] = temp;
                    }
                }
            }
            Console.WriteLine("정렬된 배열 출력");
            foreach (int i in n)
            {
                Console.Write(i + ", ");
            }
        }

        public void solution5()
        {
            System.Text.StringBuilder sb = new System.Text.StringBuilder();

            // 코드 작성
        }

        public void solution6(int n)
        {
            var chars = n.ToString().ToCharArray();
            // 코드 작성

            char temp = '1';

            for (int i = 0; i < chars.Length; i++)
            {
                for (int j = i + 1; j < chars.Length; j++)
                {
                    if (chars[i] > chars[j])
                    {
                        temp = chars[j];
                        chars[j] = chars[i];
                        chars[i] = temp;
                    }
                }
            }

            foreach (char s in chars)
            {
                Console.Write(s + ", ");
            }
        }

        public void solution7(int[] n)
        {
            String[] temp = new String[n.Length];
            for (int i = 0; i < n.Length; i++)
            {
                temp[i] = n[i] + "";
            }

            sort(temp, 0, temp.Length - 1);

            foreach (String str in temp)
            {
                Console.Write(str + ", ");
            }
        }

        void sort(String[] arr, int left, int right)
        {
            String p = arr[(left + right) / 2];
            int i = left;
            int j = right;
            String temp;

            while (i <= j)
            {
                while (stringCheck(arr[i], p)) { i++; }
                while (stringCheck(p, arr[j])) { j--; }
                if (i <= j)
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            if (j > left)
                sort(arr, left, j);
            if (i < right)
                sort(arr, i, right);
        }

        bool stringCheck(String or, String tr)
        {
            String str1 = or + tr;
            String str2 = tr + or;
            if (str1.CompareTo(str2) > 0)
                return true;
            return false;
        }
    }
}
