/* Hackerrank - Data Structures - 2D Arrays
 * Find the hourglass sum in a 6 X 6 2D array
 * Program will returns the largest (maximum) hourglass sum found in the array 
 * An hourglass is defined as follows:
 *  
 *                       a b c
 *                         d
 *                       e f g
 *                       
 */

package hourglassSum;

import java.util.Scanner;
import java.io.File;

public class Solution {
	public static void main(String[] args) throws Exception {
		int [][] arr = new int [6][6];
		int solution = 0;
		readData(arr);
		print(arr);
		solution = hourglassSum(arr);
		System.out.println("Max: " + solution);
	}
	
	/* readData: Reads in data from file
	 * User can choose positive or negative values in 2D array
	 */
	public static void readData(int arr[][]) throws Exception {
		Scanner selection = new Scanner(System.in);
		int num = 0;
		String filename = "";
		System.out.print("Enter 1 for positive values or 2 for negative values: ");
		num = selection.nextInt();
		if(num == 1) {
			filename = "HourGlassData_POSVALUES";
		} else if(num == 2) {
			filename = "HourGlassData_NEGVALUES";
			
		}
		File file = new File(filename);
		Scanner input = new Scanner(file);
		// Enters file data into array
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		input.close();
		selection.close();
	}
	
	/* print: Print array contents */
	public static void print(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/* hourglassSum: Find sum of hourglass; Return the largest value */
	// Cannot read array if index is @ edges (j = 0 or 5) or two rows at bottom (i = 4 or i = 5)
	// Read column one to left and one to right
	// If sum > max, then max equals sum
	public static int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				// If loop is at edges skip it
				if(i == 4 || i == 5 || j == 0 || j == 5) {
					continue;
				}
				// Read left, right, three down, and three down left and right
				// Sum these elements and check max
				sum = arr[i][j] + arr[i][j - 1] + arr[i][j + 1] + arr[i + 1][j] +
						arr[i + 2][j] + arr[i + 2][j - 1] + arr[i + 2][j + 1]; 
				if(sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

}
