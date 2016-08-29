	// **** SELECTION SORT ****** //
package lab2;

import java.util.Random;
import java.util.Scanner;
//--> INTERFACE --> UNCOMMENT THIS import java.util.Scanner;


// ***************************************************************************************************************************************************** //
// Author: Oscar Ivan Ricaud.
	/*Assignment: Lab 2
	Instructor: Professor Julio Urenda
	TA: Saiful Abu
	Course 2302
	Data of Last modification June 24th, 2016
	*/

// Program purpose:
	/*The purpose of this program is to implement sorting algorithms using Selection Sort (part1.java) , Quick Sort(part2.java) and a 
	  modified version of Quick Sort(part3.java). The time complexities are: Selection Sort O(n^2), Quick Sort (n logn) and a modified version of Quick Sort(n). 
	  The 3 algorithms work in a very similar fashion. It simply creates a random list using the intNode.java and asks the user for the size of the list and for
	 the element it wishes to search for, k. 
	*/
// How to operate lab2 part1.java:
	/* I went ahead and removed the ability to have the user manually enter the input. That way I can measure the time more accurately without the constraint 
	   of having the user slowly inputting the the length of the list and the element it wishes to search for.
	   By default I have set the userInputSize = 10; and the k element that we are searching for to be simply the middle element of the list.
	 */
//***************************************************************************************************************************************************** //


public class part1 {

	static int numComparisons = 0;
	public static void main(String[] args) {

		long startTime = System.nanoTime();
	
		// --> Uncomment this to obtain data from the user <--- Scanner input = new Scanner(System.in);
		// BELOW YOU CAN CHANGE THE INPUT SIZE TO BE RECEIVED FROM THE USER  //
		 System.out.println("User please enter the length of the list that you wish to generate");
		int userInputSize = 10;			// <-- Change input size here
		System.out.println("");
		intNode node = null;
		intNode randomList = generateRandomList(node, userInputSize);
		// ABOVE COMPUTER ASKS USER FOR THE LENGHT OF THE LIST IT WISHES TO RANDOMLY GENERATE // 


		// BELOW PRINTS THE RANDOM LIST IN THIS FORMAT S = {....} //
		System.out.print("Random generated set = {");
		printMe(randomList);
		System.out.print("}");
		System.out.println("");
		// ABOVE PRINTS THE LIST IN THIS FORMAT S = {....} //		
		
		
		// BELOW PRINTS THE SORTED LIST IN THIS FORMAT S = {....} //
		intNode sortMeList = selectionSort(randomList);
		System.out.print("Sorted List = {");
		printMe(sortMeList);
		System.out.print("}");
		// ABOVE PRINTS THE LIST IN THIS FORMAT S = {....} //
		System.out.println("");
		System.out.println("");
		System.out.println("When the list size is " + userInputSize + " it took " + numComparisons + " comparisons to sort the list using selection sort");
// -------> START SELECTION SORT - The following lines calls THE SELECTION SORT METHOD TO SORT THE RANDOM LIST //
			System.out.println("");
			System.out.println("********* BELOW IS USING SELECTION SORT *********");
			System.out.println("");
			
			System.out.println("");
			
			// **** BELOW YOU CAN CHANGE THE INPUT SIZE TO BE RECEIVED FROM THE USER **** //
			System.out.println("To find the kth-smallest element please enter an integer where k > 0.");
			int kth = (userInputSize+1)/2;
			// **** ABOVE YOU CAN CHANGE THE INPUT SIZE TO BE RECEIVED FROM THE USER **** //
			System.out.println("");
			System.out.print("kSmallest");
			System.out.print("({");
			printMe(randomList);
			System.out.print("} " + kth + ") = " + findMeKthSmallest(sortMeList, kth) + " is the smallest element.");
			
			System.out.println("");
			
			
			// ABOVE  CALLS THE SELECTION SORT METHOD TO SORT THE RANDOM LIST //

				System.out.println("");
		
				// BELOW CALLS THE METHOD AND RETURNS THE SMALLEST ELEMENT OF THE SORTED LIST  //
			
				// ABOVE CALLS THE METHOD AND RETURNS THE SMALLEST ELEMENT OF THE SORTED LIST  //

				// BELOW CALLS THE METHOD AND RETURNS THE MEDIAN ELEMENT OF THE SORTED LIST  //
				int median = (userInputSize+1)/2;
				System.out.println("Median Element---> " + findMeKthMedian(sortMeList, median));
				// ABOVE CALLS THE METHOD AND RETURNS THE MEDIAN ELEMENT OF THE SORTED LIST  //
				System.out.println("");
				// BELOW CALLS THE METHOD AND RETURNS THE KTH LARGEST ELEMENT OF THE SORTED LIST  //
				System.out.println("Largest Element--> " + findMeKthLargest(sortMeList));
				// ABOVE CALLS THE METHOD AND RETURNS THE KTH LARGEST ELEMENT OF THE SORTED LIST  //
				System.out.println("");
				System.out.println("********* ABOVE IS USING SELECTION SORT *********");
// -------> END SELECTION SORT
				long endTime = System.nanoTime();
				long duration = (endTime - startTime)/1000000  ; 
				System.out.println("Execution took: " + duration + " milliseconds.");
				System.out.println("When the list size is " + userInputSize + " it took " + numComparisons + " comparisons to sort the list using quick sort");

	}
	// <----- THIS METHOD FINDS THE KTH LARGEST ELEMENT  --- > //
	@SuppressWarnings("null")
	private static int findMeKthLargest(intNode sortedList) {

		while(sortedList!= null){
			if(sortedList.next == null){
				return sortedList.cargo;
			}
			sortedList = sortedList.next;
		}
		return (Integer) null;
	}
	// <----- THIS METHOD FINDS THE MEDIAN ELEMENT AND RETURNS THE MEDIAN INTEGER  --- > // 
	private static int findMeKthMedian(intNode sortMeList, int median) {
		int counter = 0; 
		while(sortMeList!=null){
			if(counter == median){
				return sortMeList.cargo;
			}
			else
				counter++;
				sortMeList = sortMeList.next;
		}
		return counter;
	}
	// <----- THIS METHOD FINDS THE KTH SMALLEST ELEMENT AND RETURNS THE SMALLEST INTEGER  --- > // 
	private static int findMeKthSmallest(intNode sortedList, int kth) {
		int temp = 0;
		while(sortedList != null){
			if(temp == kth){
				return sortedList.cargo;
			}
			else
				temp++;
			sortedList = sortedList.next;
		}
		return sortedList.cargo;

	}
	// <----- THIS METHOD SORTS RANDOM LIST USING SELECTION SORT. Time complexity is O(n^2)----> //
	private static intNode selectionSort(intNode node){
		intNode head = node;
		for(node = head; node!=null; node = node.next){
			intNode min = node;
			for(intNode node2 = node; node2!= null; node2 = node2.next){
				if(min.cargo > node2.cargo ){
					//System.out.println("min.cargo: " + min.cargo + " > node2.cargo: " + node2.cargo );
					min = node2;
						
				}
				numComparisons++;
			}
			// SWAP min node with the node actual position //
			
			intNode temp = new intNode(node.cargo);
			node.cargo = min.cargo;
			min.cargo = temp.cargo;
		//	System.out.print("min " );
		//	printMe(min);
			//System.out.println("");
		}


		return head;
	}
	
	
	// <----- THIS METHOD GENERATES RANDOM NODES OF LENGTH N, don't forget to build another method to remove repeats ------> 
	private static intNode generateRandomList(intNode node, int size) {
		Random rand = new Random();

		for(int i = 0; i < size; i ++ ){
			int  random = rand.nextInt(size*10) * (1);
			node = new intNode(random, node);
		}
		return node;
	}

	// <--- THIS METHOD PRINTS THE LIST BASED ON THE REFERENCE OF THE LIST ---> // 
	private static intNode printMe(intNode node) {

		while(node!= null){

			System.out.print(node);
			if(node.next!=null){
				System.out.print(", ");
			}

			node = node.next;
		}
		return node;
	}

}
