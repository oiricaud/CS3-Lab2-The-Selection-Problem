	// **** QUICK SORT ****** //
package lab2;

import java.util.Random;

//How to operate lab2 part3.java:
	/* This program is suppose to be a modification of Quick Sort meaning searching for kth smallest element should take on average O(n). 
	 * The program is not currently searching for kth smallest element but rather the middle element of the random list.
	 */

public class part3 {
	static int numComparisons = 0;
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(" *********QUICK SORT **********");
		// BELOW COMPUTER ASKS USER FOR THE LENGHT OF THE LIST IT WISHES TO RANDOMLY GENERATE // 
		// --> INTERFACE --> UNCOMMENT THIS  System.out.println("User please enter the length of the list that you wish to generate");

		// BELOW YOU CAN CHANGE THE INPUT SIZE TO BE RECEIVED FROM THE USER //
				//-->System.out.println("User please enter the length of the list that you wish to generate");
		int userInputSize = 10;
		intNode node = null;
		intNode randomList = generateRandomList(node, userInputSize);
		// ABOVE COMPUTER ASKS USER FOR THE LENGHT OF THE LIST IT WISHES TO RANDOMLY GENERATE // 


		// BELOW PRINTS THE RANDOM LIST IN THIS FORMAT S = {....} //
		System.out.print("Random list = {");
		printMe(randomList);
		System.out.print("}");
		// ABOVE PRINTS THE RANDOM LIST IN THIS FORMAT S = {....} //		
		intNode kth =  intNode.lookupMiddleElement(randomList, (userInputSize+1)/2);
		System.out.println("");
		System.out.println("Kth middle element: " + kth);
		
		// BELOW PRINTS THE SORTED LIST IN THIS FORMAT S = {....} //
		intNode sortMeList = quickSort(randomList, kth);
		
		
		// ABOVE PRINTS THE SORTED LIST IN THIS FORMAT S = {....} //
		

		// **** BELOW YOU CAN CHANGE THE INPUT SIZE TO BE RECEIVED FROM THE USER **** //
			//-->System.out.println("To find the kth-smallest element please enter an integer where k > 0.");
		
		// **** ABOVE YOU CAN CHANGE THE INPUT SIZE TO BE RECEIVED FROM THE USER **** //

		
		System.out.println("");
	//	System.out.print("kSmallest");
		System.out.print("The head of the list is where the kth element is located: {" );
		printMe(sortMeList);
		System.out.print("}");
		System.out.println("");
		//System.out.print("} " + kth + ") = " + findMeKthSmallest(sortMeList, kth-1) + " is the smallest element.");

		System.out.println("");
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000; 
		System.out.println("Execution took: " + duration + " milliseconds.");
		System.out.println("When the list size is " + userInputSize + " it took " + numComparisons + " comparisons to sort the list using quick sort");
		/***BELOW VISUALIZATION OF THE SWAPPING ***\ 
		intNode node1 = new intNode(1, null);
		intNode node2 = new intNode(2, null);
		intNode node3 = new intNode(3, null);
			node1.next = node2; 
			node2.next = node3;
			node3.next = null;
		System.out.println("before swap "); 
		System.out.print( printMe(node1));
		System.out.println("");
		swap(node1, node2);
		System.out.println("after swap ");
		System.out.print( printMe(node1));
	/***ABOVE VISUALIZATION OF THE SWAPPING  ***/


	}
	
	
	// @quickSort: This method gets a reference to the head of the random list and assigns the head
		// to be the pivot.  It then creates two nodes, lesserThanPivot and greaterThanPivot and compares 
		// the pivot with the element next to the pivot. Both of these nodes calls respectively the @less method 
		// and the @more method and recursively calls the @quickSort method until the base case is reached.
	private static intNode quickSort(intNode head, intNode kth) {
		
		// Assume randomList = {40, 39, 6, 53, 50, 32}
		System.out.println("");
		System.out.println("In the quick sort method");
		if(head == null){
			return head;
		}
		// Assign the first element of the list to be the pivot // 
		// pivot = 40
		
		int pivot = head.getData();
		
		System.out.println("current Pivot is: " + pivot);
		//System.out.println("QuickSort pivot		   = " + pivot);
		//System.out.println("QuickSort head.getNext	   = " + head.getNext());

		if(kth.cargo == pivot ){
			System.out.println("");
			System.out.println("Kth: " + pivot + ", Pivot: " + pivot);
			System.out.println("Kth element == pivot, return!");
			
			numComparisons++;
			return kth;
		}
		else if(kth.cargo <= pivot){
			System.out.println("");
			System.out.println("Kth: " + kth + ", Pivot: " + pivot);
			System.out.println("kth element <= pivot, search in the lesserThanPivot method!");
			
		// BELOW CALLS THE LESS METHOD // 
		// To see the procedure -- > System.out.print("All the elements that are less than " + pivot + " are: ");
		// To see the procedure -- > intNode less = 
		// lesserThanPivot = quickSort(less(40, 39))
		intNode lessThanPivot = quickSort(less(pivot, head.getNext()), kth);
		// To see the procedure -- > printMe(less);
		// To see the procedure -- > System.out.println("");
		// ABOVE CALLS THE LESS METHOD //
		numComparisons++;
		return lessThanPivot;
		}
		
		else if(kth.cargo >= pivot){
			System.out.println("");
			System.out.println("Kth: " + kth + ", Pivot: " + pivot);
			System.out.println("kth element >= pivot, search in the greaterThanPivot method!");
		// BELOW CALLS THE MORE METHOD //
		// To see the procedure -- > System.out.print("All the elements that are greater than " + pivot + " are: ");
		// To see the procedure -- > intNode more = 
		intNode greaterThanPivot = quickSort(more(pivot, head.getNext()), kth);
		// To see the procedure -- > printMe(more);
		// To see the procedure -- > System.out.println("");
		// ABOVE CALLS THE LESS METHOD //
		numComparisons++;
		return greaterThanPivot;
		}
		// once the lists have been distinguished based on
		// the pivot then we can join the lists together
		
		//return join(join(lesserThanPivot, new intNode(pivot)), greaterThanPivot);
		return null;
		

	}

	// @more method is very straight forward. This method compares the current head of the list, which is the pivot to the element
	// next of the head. Now if the pivot is less than the element next to the pivot it creates a new node, and if the pivot 
	// is not less than n.next it simply calls the @more method again until its done iterating through the list.
	private static intNode more(int pivot, intNode n) {
		
	// Assume randomList = {40, 39, 6, 53, 50, 32}
		// Essentially this method is suppose to get the elements that are greater than the pivot.
			// Such as: more = {53, 50}
		
		// 1st Method call: (pivot, n) = (40, 39))
		// 2nd Method call: (pivot, n) = (40, 6))
		// 3rd Method call: (pivot, n) = (40, 53))
		// 4th Method call: (pivot, n) = (40, 50))
		// 5th Method call: (pivot, n) = (40, 32))
		// 6th Method call: (pivot, n) = (40, null)
		if(n == null){
			// 6th Method call base case is reached. 
				// Now the @more method contains the following list. [53 |]--> [50 |]-->null
				// Now the you would think you are done but nope! You must keep going, assign [53 | ] to be the pivot 
				// and follow the same fashion and compare it to the next element.
			return null;
		}
		// 1st Method call: (pivot, n) = (40, 39), 40 < 39 = false
		// 2nd Method call: (pivot, n) = (40, 6 ), 40 < 6  = false.
		// 3rd Method call: (pivot, n) = (40, 53), 40 < 53 = true.
		// 4th Method call: (pivot, n) = (40, 50), 40 < 50 = true.
		// 5th Method call: (pivot, n) = (40, 32), 40 < 32 = false.

		if( pivot < n.getData()){
			
			/* To visualize it better uncomment the following 
			System.out.println("");
			System.out.println("Pivot: " + pivot + " n.getData: " + n.getData());
			System.out.println("Create a new node with element " +  n.getData() + "  added to the list");
			*/
			
			// 3rd Method call: return a new intNode (53, (Call the less method again, (pivot, n.next) = (40, 50)))
			// 4th Method call: return a new intNode (50, (Call the less method again, (pivot, n.next) = (40, 32)))
			return new intNode(n.getData(), more(pivot, n.getNext()));
		}

		// 1st Method call: @more(pivot, n.getNext() = (40, 6).
		// 2nd Method call: @more(pivot, n.getNext() = (40, 53).
		// 5th Method call: @more(pivot, n.getNext() = (40, null).
		return more(pivot, n.getNext() );
	}

	// @less method is very similar to as the @more method to understand just read the @more method but flip the pivot to be > rather than < 
	// of the n.getNext()
	private static intNode less(int pivot, intNode n) {
	
		if (n == null){
			return null;
		}
		if (pivot > (Integer) n.getData()){
			return new intNode(n.getData(), less(pivot, n.getNext()));

		}
		return less(pivot, n.getNext());
	}

	// @join method simply joins the list 
	

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
