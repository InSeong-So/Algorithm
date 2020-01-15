using System;
using System.Linq;
using System.Collections.Generic;

namespace Algorithm
{
    public class __20191113
    {
        static int seqSearch(int[] n, int t)
        {
            int i = 0;

            while (true)
            {
                if (i == n.Length)
                    return -1;
                if (n[i] == t)
                    return 1;

                i++;
            }
        }

        static int seqSearchSen(int[] n, int t)
        {
            int i = 0;

            while (true)
            {
                if (n[i] == t)
                    break;

                i++;
            }

            return i == n.Length ? -1 : i;
        }

        static int binSearch(int[] n, int t)
        {
            int start = 0;
            int end = n.Length - 1;

            do
            {
                int center = (start + end) / 2;

                if (n[center] == t)
                    return center;
                else if (n[center] < t)
                    start = center + 1;
                else
                    end = center - 1;
            }
            while (start <= end);

            return -1;
        }
    }
}
