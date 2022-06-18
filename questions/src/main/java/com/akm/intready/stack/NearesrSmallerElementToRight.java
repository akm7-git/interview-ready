package com.akm.intready.stack;

import java.util.Stack;

public class NearesrSmallerElementToRight {

	public static int[] getNSR(int arr[]) {
		int res[] = new int[arr.length];
		int i = arr.length - 1;
		Stack<Integer> stack = new Stack<Integer>();
		for (; i > -1; i--) {
			System.out.println("BEFORE : i value : " + arr[i] + " Stack is : " + stack.toString());
			if (stack.isEmpty()) {
				res[i] = -1;
				stack.push(arr[i]);
			} else if (!stack.isEmpty() && stack.peek() > arr[i]) {
				while (!stack.isEmpty() && stack.peek() >= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					res[i] = -1;
				} else
					res[i] = stack.peek();
				stack.push(arr[i]);
			} else if (!stack.isEmpty() && stack.peek() < arr[i]) {
				res[i] = stack.peek();
				stack.push(arr[i]);
			}

			System.out.println("AFTER: i value : " + arr[i] + " Stack is : " + stack.toString());

		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 7, 5, 4, 3, 9, 12, 4 };
		int res[] = getNSR(arr);
		for (int item : res) {
			System.out.print(item + " , ");
		}
	}

}
