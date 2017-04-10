import java.util.NoSuchElementException;

/** Implements the interface <code>FrequencyTable</code> using a
 *  binary search tree.
 *
 * @author Marcel Turcotte (turcott@eecs.uottawa.ca)
 */

public class TreeFrequencyTable implements FrequencyTable {

    // Stores the elements of this binary search tree (frequency
    // table)
    
	private static class Elem {
    
    	private String key;
        private long count;
    
        private Elem left;
        private Elem right;
    
        private Elem(String key) {
            this.key = key;
            this.count = 0;
            left = null;
            right = null;
        }
    }

    private Elem root = null; // A reference to the root element
    private int size = 0; // The size of the tree

    /** The size of the frequency table.
     *
     * @return the size of the frequency table
     */
    
    public int size() {
        return size;
    }
  
    /** Creates an entry in the frequency table and initializes its
     *  count to zero.
     *
     * @param key key with which the specified value is to be associated
     */
  
    public void init(String key) {
		if (key == null){
			throw new IllegalArgumentException();
		}
		Elem<E> current = root;
		
		if ( current == null ) {
			root = new Elem<E>( key);
		}
		boolean init = false;

		while(!added){
			int test = key.compareTo(current.key); //compare object with current node
			if (test==0){//the same
				init = true; 
				
			}else if(test<0){//less then
				if (current.left==null){ //if left is empty
					current.left = new Elem<E>(key);
					init = true;
				}else{
					current = current.left;
				}
				
			}else{//greater then
				if (current.right==null){//if right is empty
					current.right = new Elem<E>(key);
					init = true;
				}else{
					current = current.right;
				}
			}
		}
		
    
	//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
		//init(key,root);
    
    }
	
	  
    /** The method updates the frequency associed with the key by one.
     *
     * @param key key with which the specified value is to be associated
     */
  
    public void update(String key) {
    
		if (key == null){
			throw new IllegalArgumentException("null key");
		}
		Elem<E> current = root;
		
		if ( current == null ) {
			root = new Elem<E>( key);
		}
		boolean updated = false;

		while(!added){
			int test = key.compareTo(current.key); //compare object with current node
			if (test==0){//the same
				current.count++; //updates the counter if its the same
				updated=true;
				
			}else if(test<0){//less then
				if (current.left==null){ //if left is empty
					throw new NoSuchElementException("Element not found");//if it hit the end and its null
					updated=true;
				}else{
					current = current.left;
				}
				
			}else{//greater then
				if (current.right==null){//if right is empty
					throw new NoSuchElementException("Element not found");//if it hits the end of the rright and it is null
					updated=true;
				}else{
					current = current.right;
				}
			}
		}
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }
  
    /**
     * Looks up for key in this TreeFrequencyTable, returns associated value.
     *
     * @param key value to look for
     * @return value the value associated with this key
     * @throws NoSuchElementException if the key is not found
     */
  
    public long get(String key) {
		
    	if (key == null){
			throw new IllegalArgumentException("null key");
		}
		Elem<E> current = root;
		
		if ( current == null ) {
			root = new Elem<E>( key);
		}
		boolean get = false;

		while(!added){
			int test = key.compareTo(current.key); //compare object with current node
			if (test==0){//the same
				return current.count; //updates the counter if its the same
				//get=true;
				
			}else if(test<0){//less then
				if (current.left==null){ //if left is empty
					throw new NoSuchElementException("Element not found");//if it hit the end and its null
					get=true;
				}else{
					current = current.left;
				}
				
			}else{//greater then
				if (current.right==null){//if right is empty
					throw new NoSuchElementException("Element not found");//if it hits the end of the rright and it is null
					get=true;
				}else{
					current = current.right;
				}
			}
		}
		//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }
  
    /** Returns the list of keys in order, according to the method compareTo of the key
     *  objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {

		throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }

    /** Returns the values in the order specified by the method compareTo of the key
     *  objects.
     *
     *  @return the values
     */

    public long[] values() {

		throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }

    /** Returns a String representation of the tree.
     *
     * @return a String representation of the tree.
     */

    public String toString() {
        return toString( root );
    }

    // Helper method.
  
    private String toString(Elem current) {
    
        if (current == null) {
            return "{}";
        }
    
        return "{" + toString(current.left) + "[" + current.key + "," + current.count + "]" + toString(current.right) + "}";
    }
  
}
