using System;
using System.Linq;
using System.Collections.Generic;

namespace Algorithm
{
    public class __20191106
    {
        // 버블 정렬 구현
        public void bubbleSort(int[] n)
        {
            int temp = 0;

            for (int i = 0; i < n.Length; i++)
            {
                for (int j = i + 1; j < n.Length; j++)
                {
                    if (n[i] > n[j])
                    {
                        temp = n[i];
                        n[i] = n[j];
                        n[j] = temp;
                    }
                }
            }
        }

        // 삽입 정렬 구현
        public static void sort(ref int[] n)
        {
            for (int i = 1; i < n.Length; i++)
            {
                //비교 대상 데이터 저장 변수
                int neighbor = i - 1;
                //정렬 대상 데이터 저장 변수
                int standard = n[i];

                while (neighbor >= 0 && standard < n[neighbor])
                {
                    //데이터 교환
                    n[neighbor + 1] = n[neighbor];
                    neighbor--;
                }
                n[neighbor + 1] = standard;
            }

        }

        // 선택 정렬 구현
        public static void selectionSort(ref int[] n)
        {
            //정렬 대상 데이터 임시 저장 변수
            int temp;
            //최소값 저장 변수
            int min;
            //최소값 배열 인덱스 번호 저장 변수
            int index;

            for (int i = 0; i < (n.Length - 1); i++)
            {
                //변수 초기화
                min = n[i];
                index = i;

                for (int j = i; j < (n.Length - 1); j++)
                {
                    //최소값 서치, 저장
                    if ( min  > n[j + 1] )
                    {
                        min = n[j + 1];
                        index = j + 1;
                    }
                }
                //가장 작은값과 데이터 교환
                if ( n[i] != min )
                {
                    temp = n[i];
                    n[i] = min;
                    n[index] = temp;
                }
            }
        }

        // 퀵 정렬 구현
        public List<int> QSort(int[] n)
        {
            if (n.Length < 2)
            {
                return n.ToList();
            }

            int pivot = n[0];
            List<int> lower = new List<int>();
            List<int> higher = new List<int>();

            for (int i = 1; i < n.Length; i++)
            {
                if (n[i] < pivot)
                {
                    lower.Add(n[i]);
                }
                else
                {
                    higher.Add(n[i]);
                }
            }

            List<int> answer = QSort(lower.ToArray());
            answer.Add(pivot);
            answer.AddRange(QSort(higher.ToArray()));

            return answer;
        }
    }
}
