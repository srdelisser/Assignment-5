import java.util.NoSuchElementException;

/** Implements the interface <code>FrequencyTable</code> using linked
 *  elements. The linked structure is circular and uses a dummy node.
 *
 * @author Marcel Turcotte (turcott@eecs.uottawa.ca)
 */

public class LinearFrequencyTable implements FrequencyTable {

    // Linked elements

    private static class Elem {

		private String key;
		private long count;
		private Elem previous;
		private Elem next;

		private Elem(String key, Elem previous, Elem next) {
			this.key = key;
			this.count = 0;
			this.previous = previous;
			this.next = next;
		}

    }

    private Elem head;
    private int size;
	//my own variables
	//private int counterThing;// not sure hwta i want to do with it
	private LinkedList<String> listyList;//my list
	//listyList=new LinkedList<String>;
	private long[] countArray;//mt array
	
	
    /** Constructs and empty <strong>FrequencyTable</strong>.
     */

    public LinearFrequencyTable() {
		head = new Elem(null, null, null); // dummy node
		head.previous = head; // making the dummy node circular
		head.next = head; // making the dummy node circular
		size = 0;
    }

    /** The size of the frequency table.
     *
     * @return the size of the frequency table
     */

    public int size() {
		return size;
    }
  
    /** Returns the frequency value associated with this key.
     *
     *  @param key key whose frequency value is to be returned
     *  @return the frequency associated with this key
     *  @throws NoSuchElementException if the key is not found
     */

    public long get(String key) {
		/*
	    if(key==null){
			//needs to maybe throw another typ of exception
		    throw NoSuchElementException("Nothing there");
	    }
		*/
	    return get(head.next,key);//calls the recursive method to start 
		//head.next cause head is null which aint gonna work

	//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
	
    }
	//this is a recursive method to return the frequency of given key
	private long get(Elem<E> p, String key){
		//not sure if a need
		//if
		/*
		if(key==null){//base case
			throw new OutOfBoundsException();
		}
		*/
		//general case
		if(p.key==key){
			return p.count;
			//size--;//should make it hit the bottom of the recursion
		}else{
			if(p.next.key!=null){//check until we hit the last one ADDED '.key' to check the key value instead
				return get(p.next,key);//if//find way to actually make recursive
				//need way to make size the actual size again
				//return count;
			}else{//
				//if we have reached the end of the thing and we didnt find the key
				throw NoSuchElementException("Nothing there");
			}
			//return count;//else  return frequency
		}
		
		//base case		
	}


    /** Creates an entry in the frequency table and initializes its
     *  count to zero. The keys are kept in order (according to their
     *  method <strong>compareTo</strong>).
     *
     *  @param key key with which the specified value is to be associated
     *  @throws IllegalArgumentException if the key was alreaddy present
     */

    public void init(String key) {
		/*long
		size=a;
		counterThing
		if 
			throw new IllegalArgumentException();
		*/
		
		init(head.next,key);//calling the recursive methody
		//head.next cause head is null which aint gonna work

    }
	
	private void init(Elem<E> p, String key){
		if(p.key==key){//base case
			throw new IllegalArgumentException();
			//stop the screach case nothing should 
		}
		if (p.next.key!=null){//checking if the next one is null
			init(p.next,key);//if not null it calls the method again to recurive
			
		}else{//if the next one is null, then we have hit the bottom of whatever and should make a new Node with this key
			/*
			Elem newNode;
			//dont know which way that count zero should be at, like th front or the back
			newNode = new Elem(key, p, head); // making of the new node with key as element, and the 
			head.previous=newNode;//dont know if we this to set the previous of head to the new element
			p.next=newNode;//Also dont know if we really need but eh
			//newNode.count=0;
			size ++;
			*/
			//this code should add the new node at the front of the list instead
			Elem<E> newNode;
			Elem<E> temp=head.next;//just the be safe
			newNode=new Elem(key, head, temp);
			head.next=newNode;
			temp.previous=newNode;//makes 
			//newNode=
			size++;
			
		}
		
	}

    /** The method updates the frequency associed with the key by one.
     *
     *  @param key key with which the specified value is to be associated
     *  @throws NoSuchElementException if the key is not found
     */

    public void update(String key) {
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
		update(head.next, String key);//head.next cause head is null which aint gonna work
    }
	
	private void update(Elem<E> p, String key){
		
		if (p.key!=null){//checking if the next one is null
			if(p.key==key){
				p.count++;//if it hits here we leave
			}else{
				init(p.next,key);
			}
		}else{
			throw new NoSuchElementException();//cause if get here then we haven't found anything at all 
		}
		/*
		else if(p.next!=null){
			init(p.next,key);//if not null it calls the method again to recurive
		}
		}else{//if the next one is null, then we have hit the bottom of whatever and should make a new Node with this key
				
		}
		*/
	}

    /** Returns the list of keys in order, according to the method
     *  <strong>compareTo</strong> of the key objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {
		//LinkedList<String> listyList;
		listyList=new LinkedList<String>;//heres where i make a new list thingy, cause it makes sense to me
		//ie when we call this method we are making a new list thingy
		return keys(head.next);
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }
	
	private LinkedList<String> keys(Elem<E> p){
		//LinkedList<String> listyList;
		//listyList=new LinkedList<String>;
		
		//if(p.key==null){//theres nothing in the list
		//	return -1;
		//}
		//want to go though and add all the keys to the linked list by comparing them
		
		/*
		if(p.next.key==null){//so this is a case for when there is only one item present in the list
			listyList.push(p.key);
			return listyList;
		}
		*/
		if(p.key!=null &&p.previous.key==null){//this is the first item to enter to list i think
			listyList.addFirst(p.key);
		}
		//if(p.previous==head)
		//need to firgure out if in a case like 3,2,1 it will end up like 1,2,3 or 2,1,3
		if(p.key!=null){
			if(!p.key.compareTo(p.previous.key)){//if p is smaller then the key before it
				//i wanna add in before the previous then
				listyList.add(size, p.key);//this will make it replace the spot that previous once held

			}else{//when p is bigger then the one before it
				listyList.addLast(p.key);//adds it to the end of the list
			}
			//Elem temp;
			//listyList.push(p.key);//adds the key to the list
			return keys(p.next);//call again
		}else{//when it does becomee null, aka hits the dummy node again
			return listyList;//returns the list
		}
		
		
	}
	
    /** Returns an array containing the frequencies of the keys in the
     *  order specified by the method <strong>compareTo</strong> of
     *  the key objects.
     *
     *  @return an array of frequency counts
     */

    public long[] values() {
		countArray=new long[size];//creates the array to hold it all
		int counter=0;
		return values(head.next);
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }
	private long[] values(Elem<E> p){
		
		if(counter==0){//this is the first item to enter to list i think
			countArray[0]=p.count;
			counter++;
		}
		
		if(p.key!=null){
			if(!p.key.compareTo(p.previous.key)){//if p is smaller then the key before it
				tmp= countArray[counter-1];//saves the vaule of the previuos in this value
				countArray[counter-1]=null;
				countArray[counter-1]=p.count;
				countArray[counter]=tmp;
				count++;
			}else{//when p is bigger then the one before it
				countArray[counter]==p.key;
				count++;
			}
			
			return values(p.next);//call again
		}else{
			return conutArray;
		}
			
	}

    /** Returns a <code>String</code> representations of the elements
     * of the frequency table.
     *  
     *  @return the string representation
     */

    public String toString() {

		StringBuffer str = new StringBuffer("{");
		Elem p = head.next;

		while (p != head) {
			str.append("{key="+p.key+", count="+p.count+"}");
			if (p.next != head) {
			str.append(",");
			}
			p = p.next;
		}
		str.append("}");
		return str.toString();
    }
/*
	private boolean compareTo(Node<E> p){
		return this.key>p.key;
	}
	*/
}
