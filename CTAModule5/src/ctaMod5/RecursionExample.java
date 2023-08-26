package ctaMod5;
import java.util.Scanner;

/*
 * Author: Semisi Rigby
 * To demonstrate recursion, a list of numbers will be asked for 
 * and stored within an array. The array and the index of the array
 * will be used to recursively produce the product of the numbers
 * contained within the array.
 */


public class RecursionExample {

	// recursive method to call; params: array, index
	static int recursiveProduct(int arr[], int index) {
		// termination position
		if (index == arr.length) {
			return 1;
		}
		else {
			// returns recursive method for next index in the array
			return (arr[index] * recursiveProduct(arr, index + 1));
		}
		
	}
	
	// main method for asking for input from user and applying recursive method
	public static void main(String[] args) {
		
		// initialize instance of Scanner object
		Scanner sc = new Scanner(System.in);
		
		// create an array with length 5 for storing user input 
		int[] arr = new int[5];
		
		// description for program
		System.out.println("Enter 5 integers to use for multiplication using recursion.");	

		// for loop for taking user input and storing it into the array for manipulation
		for (int i = 0; i < 5; i++) { 
			System.out.println("Enter integer: ");
			// try/catch block for ensuring that input is an integer
			try {
				// store input into next spot in array
				arr[i] = sc.nextInt();
			}
			catch (Exception e) {
				// message for invalid input upon exception catch
				System.out.println("Ensure that input is in the form of an integer.");
				return;
			}
		}
		
		// create a variable to store the result for viewing
		int result = recursiveProduct(arr, 0);
		
		// display the result to the user
		System.out.println("Product of the entered integers: " + result);
		
		// close instance of the scanner object
		sc.close();
		
	}

}
