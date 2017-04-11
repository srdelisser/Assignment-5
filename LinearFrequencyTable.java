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
	//private LinkedList<String> listyList;//my list
	//listyList=new LinkedList<String>;
	//private long[] countArray;//mt array
	
	
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
		if (key == null){
			throw new IllegalArgumentException("key is null");
		}
		Elem p = head.next;
		
		while(p.key!=null){
			if(key.compareTo(p.key)==0){//if they are the same
				return p.count;
			}
			p=p.next;
		}
		throw new NoSuchElementException("Key not Found");	
		
	//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
    }

    /** Creates an entry in the frequency table and initializes its
     *  count to zero. The keys are kept in order (according to their
     *  method <strong>compareTo</strong>).
     *
     *  @param key key with which the specified value is to be associated
     *  @throws IllegalArgumentException if the key was alreaddy present
     */

    public void init(String key) {
		if (key == null){
			throw new IllegalArgumentException("key is null");
		}
		
		Elem p = head.next;
		//if(p.next==null){
		
		while(p.key!=null){
			int test = key.compareTo(p.key); //compare object with current node
			if (test==0){//the same
				throw new IllegalArgumentException("key already there");
			}p=p.next;
		}
		
		if(head.next==head){
			head.next= new Elem(key, head, head.next);
			head.previous=head.next;
		}else{
			Elem init = head.next; //point to dummy element
    		while(init != head && init.key.compareTo(key) < 0){  //while value less then key
    			init=init.next; 
    		}

    		Elem next = init.next; //what wouldve come after the init elem

    		init.next = new Elem(key, init, next); 
    		next.previous = init.next;
   
		}size++;
	}

    /** The method updates the frequency associed with the key by one.
     *
     *  @param key key with which the specified value is to be associated
     *  @throws NoSuchElementException if the key is not found
     */

    public void update(String key) {
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
		
		Elem update = head.next; 
		while(update != head && update.key.compareTo(key)!= 0){  //havent hit the dummy yet, 
			update=update.next; //running through this loop with my woes
		}

		if (update==head){
			throw new NoSuchElementException("Key not Found"); 
		}else{//else update count
			update.count++; 
		}
	}

    /** Returns the list of keys in order, according to the method
     *  <strong>compareTo</strong> of the key objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {
		LinkedList<String> listyList;
		listyList=new LinkedList<String>();//heres where i make a new list thingy, cause it makes sense to me
		
		Elem runner=head.next;
		
		while(runner.key!=null){
			listyList.addLast(runner.key);
			runner=runner.next;
		}
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
		return listyList;
    }
	
    /** Returns an array containing the frequencies of the keys in the
     *  order specified by the method <strong>compareTo</strong> of
     *  the key objects.
     *
     *  @return an array of frequency counts
     */

    public long[] values() {
		long[] countArray;
		countArray=new long[size];//creates the array to hold it all
		int counter=0;
		
		Elem p= head.next;
		while(p!=head){
			countArray[counter]=p.count;
			p=p.next;
			counter++;
		}
		
		return countArray;
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

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
