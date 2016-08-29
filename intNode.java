package lab2;

public class intNode {
	int cargo; 
	intNode next;


	public intNode () { 
		cargo = 0; 
		next = null; 
	} 
	public intNode(int givenval){
		cargo = givenval;
	}

	public intNode (Object cargo, intNode next) { 
		this.cargo = (Integer) cargo; 
		this.next = next; 
	} 

	public String toString () { 
		return cargo + ""; 
	} 
	public Integer getData(){
		return cargo;
	}
	public intNode getNext(){
		return next;
	}
	public intNode prev(intNode head, intNode tail){
		intNode previous = null;
		while(head != null){
			if(head.next == tail){
				previous = head;
				return previous;
			}
			head = head.next;
		}
		return previous;

	}

	// <--- YOU DONT NEED THIS CODE BUT JUST IN CASE DONT DELETE --->
	public static void printList(intNode x){
		if (x!= null){
			System.out.print(x.cargo+" ");
			printList(x.next);
		}
	} 
	public static intNode lookup(intNode h,  int n) {
		for(intNode p = h.next; p != null; p = p.next )
			if( p.cargo == n ) 
				return p; 
		return null;             // return null if item not found
	}
	// <--- YOU DONT NEED ABOVE CODE BUT DONT DELETE FOR FUTURE REFERENCE --> //
	
	public static intNode lookupMiddleElement(intNode h, int n){
		int counter = 0;
		while(h!=null){
			if(n == counter){
				return h;
			}
			counter++;
			h= h.next;
		}
		return null;
	}

}

