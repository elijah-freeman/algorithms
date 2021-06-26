/*H*****************************************************************************
 * Filename: Main.java
 * Description: 
 * Comment:
 * Modified: 2021-06-05	Major revision.
 * Author: Elijah Freeman (elijah@elijahfreeman.com, elijahfreeman.com)
 ****************************************************************************H*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.*;

/**
 * Main class that is used for execution of sorting algorithms.
 *
 * @author Elijah Freeman (elijahff@uw.edu)
 * @version 1.0 (6 February 2020)
 */
public class Main {

	private static int LIST_SIZE = 0;
	/**
	 * Driver for program that sorts Linked Lists using a BubbleSort and a ShellSort.
	 *
	 * @param args used for command line.
	 */
	public static void main(String[] args) {
		//Directions: Rename the below file name to sort elements in that txt file.
		String fileName = "test/random10000.txt";
		PrintStream output = null;
		try {
			output = new PrintStream(new File("test/Output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR " + e);
			System.exit(1);
		}
		//displays the sorted list to the console.
		//writes appropriate data to text file.
		//resultBubbleSort(fileName, output);
		//resultShellSort(fileName, output);
		
	
		//int[] array = {3, 2, 7, 1, 9, 5, 8, 4};
		//System.out.printf("Input Array: %s\n", Arrays.toString(array));
		//Sort sort = new Sort();
		//sort.bubbleSort(array);
		//System.out.printf("Output Array: %s\n", Arrays.toString(array));
		
		Sort sort = new Sort();
		LinkedNode<Integer> head = readValues(fileName);
		//TODO fix bubble sort for linked list. Losing most of the values somewhere.
		head = sort.bubbleSort(head);
		System.out.printf("head=%d\n\n\n", head.getElement());
		//System.out.print(head.getElement());
		displayList(head);

	}

	/**
	 * Reads data from a txt file and inserts each data point into a node. Links nodes together
	 * to form a linked list.
	 *
	 * @param fileName name of the input file.
	 * @return LinkedNode<Integer> head reference to the first node in the list.
	 */
	public static LinkedNode<Integer> readValues(String fileName) {
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
		LinkedNode<Integer> head = new LinkedNode<>();
		head.setElement(Integer.parseInt(input.next()));
		LinkedNode<Integer> temp = head;
		while(input.hasNext()) {
			LinkedNode<Integer> node = new LinkedNode<>(Integer.parseInt(input.next()));
			temp.setNext(node);
			temp = node;
			LIST_SIZE++;
		}
		temp.setNext(null);
		return head;
	}

	/**
	 * Traverses the linked strucure and displays to the console the elements of each node.
	 *
	 * @param head reference to the first node in the list.
	 */
	public static void displayList(LinkedNode<Integer> head) {
		LinkedNode<Integer> current = head;
		while(current != null) {
			System.out.print(current.getElement() + " ");
			current = current.getNext();
		}
	}

	//public static void resultShellSort(String fileName, PrintStream output) {
	//	System.out.println();
	//	System.out.println();
	//	LinkedNode<Integer> head = readValues(fileName);
	//	System.out.println();
	//	System.out.println("Unsorted List:");
	//	displayList(head);
	//	output.println("First 20 passes: shellsort  " + fileName);
	//	output.println("gap       pass      cmp            exch");
	//	output.println("--------------------------------------");
	//	Sort sorting = new Sort(output);
	//	head = sorting.shellSort(head);
	//	System.out.println();
	//	System.out.println();
	//	System.out.println("Shelled Sorted list: ");
	//	displayList(head);
	//	for (int i = 0; i < 10; i++) {
	//		output.println();
	//	}
	//}

	//public static void resultBubbleSort(String fileName, PrintStream output) {
	//	System.out.println();
	//	System.out.println();
	//	LinkedNode<Integer> head = readValues(fileName);
	//	System.out.println();
	//	System.out.println("Unsorted List:");
	//	displayList(head);
	//	output.println("First 20 passes: bubbleSort  " + fileName);
	//	output.println("         pass        cmp         exch");
	//	output.println("---------------------------------------");
	//	Sort sorting = new Sort(output);
	//	head = sorting.bubbleSort(head);
	//	System.out.println();
	//	System.out.println();
	//	System.out.println("Bubbled Sorted List");
	//	displayList(head);
	//	for (int i = 0; i < 10; i++) {
	//		output.println();
	//	}
	//}
}
