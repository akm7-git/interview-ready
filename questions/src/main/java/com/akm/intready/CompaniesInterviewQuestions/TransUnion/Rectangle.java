package com.akm.intready.CompaniesInterviewQuestions.TransUnion;

import java.io.*;
import java.util.*;


public class Rectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        if (T >= 11 || T <= 0)
        {
            throw new IOException("Invalid value");
        }
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            if (N > Math.pow(10,5) || N <= 0)
            {
                throw new IOException("Invalid value");
            }
            int[][] arr = new int[N][2];
            for(int i_arr = 0; i_arr < N; i_arr++)
            {
                String[] arr_arr = br.readLine().split(" ");
                for(int j_arr = 0; j_arr < arr_arr.length; j_arr++)
                {
                    arr[i_arr][j_arr] = Integer.parseInt(arr_arr[j_arr]);
                }
            }

            long out_ = solve(N, arr);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static long solve(int N, int[][] arr) throws IOException {
        // Write your code here
        long result = 0;
        int max_height=0;
        int max_width=0;
        for (int i=0; i < N; i++)
        {
            if (arr[i][0] > Math.pow(10,7) || arr[i][0] <= 1)
            {
                throw new IOException("Invalid value");
            }
            if (arr[i][1] > Math.pow(10,7) || arr[i][1] <= 1)
            {
                throw new IOException("Invalid value");
            }
            if(max_height < arr[i][1])
                max_height = arr[i][1];
            if(max_width < arr[i][0])
                max_width = arr[i][0];
        }

        double[][] matrix=new double[(int)Math.ceil((double)max_height/2)*2][(int)Math.ceil((double)max_width/2)*2];

        double y_axis= ((double)max_width)/2;
        double x_axis= ((double)max_height)/2;

        for (int i=0; i < N; i++)
        {
            double width = ((double)arr[i][0])/2;
            double height = ((double)arr[i][1])/2;
            for (double x=x_axis; x < height+x_axis; x++)
            {
                for (double y=y_axis; y < width+y_axis; y++)
                {
                    matrix[(int) x][(int) y]=1;
                }
                for (double y=y_axis; y >= y_axis-width; y--)
                {
                    matrix[(int) x][(int) y]=1;
                }
            }
            for (double x=x_axis; x >= x_axis-height; x--)
            {
                for (double y=y_axis; y < y_axis+width; y++)
                {
                    matrix[(int) x][(int) y]=1;
                }

                for (double y=y_axis; y >= y_axis-width; y--)
                {
                    matrix[(int) x][(int) y]=1;
                }
            }
        }

        for (int x=0; x <max_height; x++) {
            for (int y = 0; y <max_width; y++) {
                if (matrix[x][y] == 1)
                    result++;
            }
        }
        return result;

    }
}