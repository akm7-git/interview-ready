package com.akm.intready.stack;

import java.util.Stack;

public class NearesrSmallerElementToLeft {

	public static int[] getNSL(int arr[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int res[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("BEFORE : i value : " + arr[i] + " Stack is : " + stack.toString());

			if (stack.isEmpty()) {
				res[i] = -1;
			}

			else if (stack.peek() < arr[i]) {
				res[i] = stack.peek();
			}

			else if (stack.peek() > arr[i]) {
				while (stack.peek() > arr[i]) {
					stack.pop();
					if (stack.isEmpty())
						break;
				}
				if (stack.isEmpty()) {
					res[i] = -1;
				} else {
					res[i] = stack.peek();
				}
			}
			stack.push(arr[i]);
			System.out.println("After : i value : " + arr[i] + " Stack is : " + stack.toString());
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 2 };
		int res[] = getNSL(arr);
		for (int item : res)
			System.out.print(item + " , ");
	}

}
