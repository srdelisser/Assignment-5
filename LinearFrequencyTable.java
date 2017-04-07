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
	private int counterThing;// not sure hwta i want to do with it

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
	    if(key==null){
			//needs to maybe throw another typ of exception
		    throw NoSuchElementException("Nothing there");
	    }
	    return get(first,key);//calls the recursive method to start 

	//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
	
    }
	//this is a recursive method thatll go through and count up the frequency
	private long get(Node<E> p, String key){
		//not sure if a need
		if(p==null){//base case
			throw new OutOfBoundsException();
		}
		//*************way #1
		if (size==0){//base case
			if(p.key==key){
				count++;
				//try to reset size here perhaps
			}
			return count;
		}
		//general case
		if(p.key==key){
			count++;
			//size--;//should make it hit the bottom of the recursion
		}
		//************way #2
		//base case
		if(p.next!=null){//check until we hit the last one
			return get(p.next,key);//if//find way to actually make recursive
			//need way to make size the actual size again
			//return count;
		}else{//
			if (count==0){//if we have reached the end of the thing and we didnt find the key
				throw NoSuchElementException("Nothing there");
			}
			return count;//else  return frequency
		}
		
	}


    /** Creates an entry in the frequency table and initializes its
     *  count to zero. The keys are kept in order (according to their
     *  method <strong>compareTo</strong>).
     *
     *  @param key key with which the specified value is to be associated
     *  @throws IllegalArgumentException if the key was alreaddy present
     */

    public void init(String key) {
		long
		size=a;
		counterThing
		if 
			throw new IllegalArgumentException();
		
		init(first,key);//calling the recursive methody

    }
	
	private void init(Node<E> p, String key){
		if(p.key==key){//base case
			throw new IllegalArgumentException();
			//stop the screach case nothing should 
		}
		if (p.next!=null){//checking if the next one is null
			init(p.next,key);//if not null it calls the method again to recurive
		}else{//if the next one is null, then we have hit the bottom of whatever and should make a new Node with this key
			
			
		}
		
	}

    /** The method updates the frequency associed with the key by one.
     *
     *  @param key key with which the specified value is to be associated
     *  @throws NoSuchElementException if the key is not found
     */

    public void update(String key) {
	
		throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }

    /** Returns the list of keys in order, according to the method
     *  <strong>compareTo</strong> of the key objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {

		throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }

    /** Returns an array containing the frequencies of the keys in the
     *  order specified by the method <strong>compareTo</strong> of
     *  the key objects.
     *
     *  @return an array of frequency counts
     */

    public long[] values() {

	throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

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

}
