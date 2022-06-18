package com.akm.intready.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MaxAreaHistogram {

	public static int getMAH(int arr[]) {
		Map<Integer, Integer> nsl = getNSL(arr);
		Map<Integer, Integer> nsr = getNSR(arr);

		System.out.println(nsr);
		System.out.println(nsl);

		int maxArea = Integer.MIN_VALUE;
		int area[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int res =(( nsr.get(i) - nsl.get(i)) - 1 )* arr[i];
			if (res > maxArea) {
				maxArea = res;
			}
			area[i] = res;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(" for i : " + i + " - value : " + arr[i] + " max area : " + area[i]);
		}

		return maxArea;
	}

	private static Map<Integer, Integer> getNSL(int arr[]) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		int res = Integer.MIN_VALUE;
		Map<Integer, Integer> nsl = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {

			if (stack.isEmpty()) {
				res = -1;
			}

			else if (stack.peek().get(0) < arr[i]) {
				res = stack.peek().get(1);
			}

			else if (stack.peek().get(0) > arr[i]) {
				while (stack.peek().get(0) > arr[i]) {
					stack.pop();
					if (stack.isEmpty())
						break;
				}
				if (stack.isEmpty()) {
					res = -1;
				} else {
					res = stack.peek().get(1);
				}
			}
			List<Integer> data = new ArrayList<Integer>();
			data.add(arr[i]);
			data.add(i);
			stack.push(data);
			nsl.put(i, res);
		}
		return nsl;

	}

	private static Map<Integer, Integer> getNSR(int arr[]) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		int res = Integer.MIN_VALUE;
		Map<Integer, Integer> nsr = new HashMap<Integer,Integer>();

		for (int i = arr.length - 1; i > -1; i--) {

			if (stack.isEmpty()) {
				if (i == 0)
					res = 0;
				else
					res = arr.length;
			}

			else if (stack.peek().get(0) < arr[i]) {
				res = stack.peek().get(1);
			}

			else if (stack.peek().get(0) > arr[i]) {
				while (stack.peek().get(0) > arr[i]) {
					stack.pop();
					if (stack.isEmpty())
						break;
				}
				if (stack.isEmpty()) {
					res = arr.length;
				} else {
					res = stack.peek().get(1);
				}
			}
			List<Integer> data = new ArrayList<Integer>();
			data.add(arr[i]);
			data.add(i);
			stack.push(data);
			nsr.put(i, res);
		}
		return nsr;

	}

	public static void main(String[] args) {
		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Max Area : " + getMAH(arr));
	}

}
