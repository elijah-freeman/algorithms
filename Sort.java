/*H*****************************************************************************
 * Filename: Sort.java
 * Description: 
 * Comment:
 * Modified: 2021-06-05	File review and refactor.
 * Author: Elijah Freeman (elijah@elijahfreeman.com, elijahfreeman.com)
 ****************************************************************************H*/

import java.io.*;

/**
 * Contains sorting algorithms.
 *
 * @author Elijah Freeman 
 * @version 2.0 (June 26, 2021)
 */
public class Sort {

	private static boolean bubbleFlag;
	private boolean sortType;
	private boolean callFromShell;
	private static PrintStream output;

	public Sort() {}

	public Sort(PrintStream output) {
		this.output = output;
		bubbleFlag = true;
	}

	/**
	 * In place sorting method using the bubble sort algorithm.
	 *
	 * @param  array  the array to be sorted.
	 */
	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	/**
	 * In place sorting method using the bubble sort algorithm.
	 *
	 * @param  head  the pointer the the first element of a linked list.
	 */
	public LinkedNode<Integer> bubbleSort(LinkedNode<Integer> head) {
		LinkedNode<Integer> pointer = head;
		LinkedNode<Integer> result = head;
		while (pointer != null) {
			LinkedNode<Integer> previous = result;
			LinkedNode<Integer> current = result;
			while (current.getNext() != null) {
				if (current.getElement() > current.getNext().getElement()) {
					if (current == result) {
						LinkedNode<Integer> next = current.getNext();
						current.setNext(next.getNext());
						next.setNext(previous);
						previous = next;
						current = previous.getNext();
						result = next;
					} else {
						previous.setNext(current.getNext());
						current.setNext(current.getNext().getNext());
						previous.getNext().setNext(current);
						previous = previous.getNext();
					}
					pointer = pointer == current ? previous : pointer;
				} else {
					previous = current;
					current = current.getNext();
				}
			}
			pointer = pointer.getNext();
		}
		return result;
	}


	//public LinkedNode<Integer> shellSort(LinkedNode<Integer> first) {

	//	LinkedNode<Integer> current;
	//	LinkedNode<Integer> next;
	//	LinkedNode<Integer> currentPrevious;
	//	LinkedNode<Integer> nextPrevious;
	//	LinkedNode<Integer> listCounter = first;

	//	sortType = false;
	//	boolean shellFlag = false;
	//	boolean swapCheck = true;
	//	int comparison = 0;
	//	int exchange = 0;
	//	int numPass = 0;
	//	int totalPasses = 0;
	//	int totalComparisons = 0;
	//	int totalExchanges = 0;
	//	int listLength = 0;
	//	int k = 0;
	//	int gap = 0;
	//	int counter = 0;
	//	int numberPrints = 0;

	//	gap = (int) ((Math.pow(3, k) - 1) / 2);

	//	while (listCounter != null) {
	//		listLength++;
	//		listCounter = listCounter.getNext();
	//	}


	//	int tempGap = 0;
	//	for (; gap < listLength; gap = (int) ((Math.pow(3, k) -1)/2)) {
	//		++k;
	//		tempGap = gap;
	//	}
	//	k--;
	//	gap = tempGap;


	//	while (gap > 1) {
	//		current = first.getNext();
	//		currentPrevious = first;
	//		next = first.getNext();
	//		nextPrevious = first;
	//		swapCheck =  true;

	//		while (counter < gap) {
	//			counter++;
	//			nextPrevious = next;
	//			next = next.getNext();
	//		}
	//		counter = 0;

	//		while(swapCheck) {
	//			swapCheck = false;
	//			while (next != null) {
	//				if (current.getElement() > next.getElement()) {
	//					nextPrevious.setNext(next.getNext());
	//					next.setNext(current.getNext());
	//					currentPrevious.setNext(next);
	//					current.setNext(nextPrevious.getNext());
	//					nextPrevious.setNext(current);
	//					exchange++;
	//					swapCheck =  true;
	//				}

	//				currentPrevious = currentPrevious.getNext();
	//				nextPrevious = nextPrevious.getNext();
	//				current = currentPrevious.getNext();
	//				next = nextPrevious.getNext();
	//				comparison++;
	//			}
	//			current = first.getNext();
	//			currentPrevious = first;
	//			next = first.getNext();
	//			nextPrevious = first;
	//			numPass++;
	//			while (counter < gap) {
	//				counter++;
	//				nextPrevious = next;
	//				next = next.getNext();
	//			}
	//			counter = 0;
	//		}

	//		numPass -= 1;
	//		if (exchange != 0 && numberPrints < 20) {
	//			writeOutput(first, gap, numPass, comparison, 
	//					exchange, shellFlag, sortType);
	//			numberPrints++;
	//		}
	//		gap = (int) ((Math.pow(3, --k) - 1) / 2);
	//		totalPasses += numPass;
	//		totalComparisons += comparison;
	//		totalExchanges += exchange;
	//	}
	//	if (gap == 1) {
	//		callFromShell = true;
	//		first = bubbleSort(first);
	//		writeOutput(first, gap , numPass, comparison, exchange, shellFlag, sortType);
	//		callFromShell = false;
	//	}
	//	output.println("------------------------------------------");
	//	output.println("Total:    pass          cmp          exch");
	//	writeOutput(first, gap, totalPasses, totalComparisons, totalExchanges, 
	//			shellFlag, sortType);
	//	return first;
	//}


	private void writeOutput(LinkedNode<Integer> head, int gap, int thePass, 
			int theComparison, int theExchange, boolean flag, boolean sortType) {

		if (sortType && flag) {
			output.printf("          %-10d%-15d%-15d", thePass, theComparison, theExchange);
			LinkedNode<Integer> current = head;
			//prints List for each pass that is recorded (written in the txt file). 
			//Uncomment to view
			//            while (current != null) {
			//                output.printf(current.getElement() + " ");
			//                current = current.getNext();
			//            }

		} else {
			output.printf("%-10d%-10d%-15d%-15d", gap, thePass, theComparison, theExchange);
			LinkedNode<Integer> current = head;
			//prints list for each pass that is recorded (written in the txt file). 
			//Uncomment to view
			//            while (current != null) {
			//                output.printf(current.getElement() + " ");
			//                current = current.getNext();
			//            }
		}
			output.println();
		}
}
