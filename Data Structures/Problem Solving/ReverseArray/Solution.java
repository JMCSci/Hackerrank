/* Hackerrank - Data Structures - Arrays
 * Given an array of integers, print each element in reverse order as a single line of space-separated integers.
 */

package arrays_ds;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = 0;
		int i = 0;
		System.out.print("Enter array size: ");
		size = input.nextInt();
		int [] a = new int [size];
		System.out.print("Enter values: ");
		
		while(i < size) {
			a[i] = input.nextInt();
			i++;
		}
		
		print(a);
		int [] solution = reverseArray(a, size);
		print(solution);
		input.close();
	}
		
	/* reverse: Reverse order of array */
	public static int [] reverseArray(int a[], int size) {
		int [] b = new int [size];
		// Copy array contents to a new array; reverse the order
		for(int i = a.length - 1; i >= 0; i--) {
			b[b.length - size] = a[i];
			size--;
		}
		return b;
	}
		
	/* print: Print array contents */
	public static void print(int array []) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
