using System;
using System.Collections;
using System.Collections.Generic;

namespace Algorithm
{
    public class __20191023
    {
        public void solution1(String str)
        {
            // 연산 속도를 위해 임의적으로 제한
            if (str.Length > 128)
                Console.WriteLine("옳지 못한 접근입니다.");

            bool[] char_set = new bool[128];
            for (int i = 0; i < str.Length; i++)
            {
                int val = str[i];
                if (char_set[val])
                    Console.WriteLine("중복된 문자가 존재합니다.");
                char_set[val] = true;
            }

            Console.WriteLine("중복된 문자가 존재하지 않습니다.");
        }

        public char[] solution2(String str, int trueLength)
        {
            int spaceCount = 0, index, i = 0;
            char[] cstr = str.ToCharArray();

            for (i = 0; i < trueLength; i++)
            {
                if (cstr[i] == ' ')
                    spaceCount++;
            }

            index = trueLength + spaceCount * 2;
            char[] array = new char[index];
            Array.Copy(cstr, array, index);

            if (trueLength < cstr.Length)
                array[trueLength] = '\0'; // 배열의 끝

            for (i = trueLength - 1; i >= 0; i--)
            {
                if (array[i] == ' ')
                {
                    array[index - 1] = '0';
                    array[index - 2] = '2';
                    array[index - 3] = '%';
                    index = index - 3;
                }
                else
                {
                    array[index - 1] = array[i];
                    index--;
                }
            }

            return array;
        }

        public int[] solution3(int[] array, int[][] commands)
        {
            int[] answer = new int[commands.Length];

            List<int> list = new List<int>();

            for (int i = 0; i < commands.Length; i++)
            {
                Console.WriteLine("시작");
                for (int j = commands[i][0]; j <= commands[i][1]; j++)
                {
                    if (commands[i][0] == commands[i][1])
                    {
                        list.Add(array[j - 1]);
                        break;
                    }
                    list.Add(array[j - 1]);
                }

                list.Sort();
                answer[i] = list[commands[i][2] - 1];
                list.Clear();
            }

            return answer;
        }

        public void solution4(int[] n)
        {
            String input = Console.ReadLine();

            String[] nums;

            nums = input.Split(" ");

            for (int i = 0; i < n.Length; i++)
                n[i] = Int32.Parse(nums[i]);

            int tmp = 0;

            for (int i = 0; i < n.Length - 1; i++)
            {
                for (int j = 0; j < n.Length - 1; j++)
                {
                    if (n[j] > n[j + 1])
                    {
                        tmp = n[j];
                        n[j] = n[j + 1];
                        n[j + 1] = tmp;
                        foreach (int p in n)
                            Console.Write(" " + p + " ");
                        Console.WriteLine();
                    }
                }
            }
        }
    }
}
