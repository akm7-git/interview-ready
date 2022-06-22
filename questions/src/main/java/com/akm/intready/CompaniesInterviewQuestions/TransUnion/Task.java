package com.akm.intready.CompaniesInterviewQuestions.TransUnion;

import java.io.*;
import java.util.*;


public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        if (T >= 20 || T <= 0)
        {
            throw new IOException("Invalid value");
        }
        for(int t_i = 0; t_i < T; t_i++)
        {
            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_type = br.readLine().split(" ");
            int[] type = new int[Q];
            for(int i_type = 0; i_type < arr_type.length; i_type++)
            {
                type[i_type] = Integer.parseInt(arr_type[i_type]);
            }
            String[] arr_X = br.readLine().split(" ");
            int[] X = new int[Q];
            for(int i_X = 0; i_X < arr_X.length; i_X++)
            {
                X[i_X] = Integer.parseInt(arr_X[i_X]);
            }

            long[] out_ = solve(Q, type, X);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
                System.out.print(" " + out_[i_out_]);
            }

            System.out.println();

        }

        wr.close();
        br.close();
    }
    static long[] solve(int Q, int[] type, int[] X){
       /*
       Q: Number of queries
       type: array denoting the type of each query 
       X:
       array denoting parameter of each query
       */

        long[] result = {0};
        LinkedList<Long> output= new LinkedList<>();
        LinkedList<Integer> ls= new LinkedList<>();
        for (int i=0; i < X.length; i++)
        {
            if(type[i] == 1)
            {
                ls.add(X[i]);
            }
            if(type[i] == 2)
            {
                removeElementFromList(ls,X[i]);
            }
            if(type[i] == 3)
            {
                if(ls.isEmpty())
                {
                    output.add(Long.valueOf(0));
                }
                else{
                    int sum=performXOROperation(ls,X[i]);
                    output.add(Long.valueOf(sum));
                }
            }
        }
        if (! output.isEmpty())
            result=output.stream()
                .mapToLong(Long::longValue)
                .toArray();
        return result;
    }

    public static int performXOROperation(LinkedList<Integer> ls, int nos)
    {
        int sum=0;
        for (Iterator<Integer> iter = ls.iterator(); iter.hasNext();) {
            Integer i = iter.next();
            sum= sum+ (i ^ nos);
        }
        return sum;
    }
    public static void removeElementFromList(LinkedList<Integer> ls, int nos)
    {
        for (Iterator<Integer> iter = ls.iterator(); iter.hasNext();) {
            Integer i = iter.next();
            if (i.equals(nos)) {
                iter.remove();
            }

        }
    }
}


/***
 Sample inputs

 20
 3
 1 2 3
 1 2 3
 10
 1 1 1 1 1 3 2 3 3 3
 3 7777777 3444444 199999 3 566666 3 178 345 234
 5
 1 1 1 1 3
 3 3 3 5 4
 10
 1 1 1 1 2 3 2 3 1 3
 57 67 77 87 57 1317 67 1314 99 0
 10
 1 1 3 1 2 1 2 3 1 3
 12 12 11 12 12 14 9 1023 5 1023
 8
 1 2 1 1 1 3 3 3
 21 400 434 66 400 152 893 85
 8
 1 3 2 3 1 1 3 1
 210 817 761 76 939 757 950 761
 8
 2 1 3 1 1 3 1 3
 743 837 83 144 960 368 743 656
 8
 3 3 1 1 1 2 3 1
 485 449 771 349 931 46 950 46
 8
 1 1 3 2 1 3 1 3
 666 44 297 137 287 24 137 885
 8
 2 1 1 1 3 3 1 3
 529 372 916 353 210 37 529 590
 8
 3 3 3 2 1 1 1 1
 929 150 900 702 948 786 779 702
 8
 3 1 1 1 3 3 2 1
 963 294 48 90 131 796 553 553
 8
 1 2 3 1 1 3 3 1
 936 945 803 977 449 781 846 945
 8
 3 1 1 3 1 1 2 3
 519 58 255 763 955 16 16 362
 8
 2 1 3 1 1 3 1 3
 653 844 53 301 832 163 653 467
 8
 3 2 1 3 3 1 1 1
 655 62 103 777 44 204 277 62
 8
 1 1 1 3 3 2 1 3
 348 819 612 764 352 240 240 602
 8
 3 1 1 1 2 3 1 3
 280 615 668 809 347 802 347 542
 8
 2 3 3 1 1 1 3 1
 664 67 846 633 57 334 500 664

 */