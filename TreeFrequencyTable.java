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
        Elem current = root;
        
        if ( current == null ) {
            root = new Elem( key);
        }
        boolean init = false;

        while(!init){
            int test = key.compareTo(current.key); //compare key with current key
            if (test==0){//the same
                init = true; 
                
            }else if(test<0){//less then
                if (current.left==null){ //if left is empty
                    current.left = new Elem(key);
                    init = true;
                }else{
                    current = current.left;
                }
                
            }else{//greater then
                if (current.right==null){//if right is empty
                    current.right = new Elem(key);
                    init = true;
                }else{
                    current = current.right;
                }
            }
        }
    //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
    }
    
      
    /** The method updates the frequency associed with the key by one.
     *
     * @param key key with which the specified value is to be associated
     */
  
    public void update(String key) {
    
        if (key == null){
            throw new IllegalArgumentException("null key");
        }
        Elem current = root;
        
        if ( current == null ) {
            root = new Elem( key);
        }
        boolean updated = false;

        while(!updated){
            int test = key.compareTo(current.key); //compare key with current key
            if (test==0){//the same
                current.count++; //updates the counter if its the same
                updated=true;
                
            }else if(test<0){//less then
                if (current.left==null){ //if left is empty
                    throw new NoSuchElementException("Element not found");//if it hit the end and its null
                    //updated=true;
                }else{
                    current = current.left;
                }
                
            }else{//greater then
                if (current.right==null){//if right is empty
                    throw new NoSuchElementException("Element not found");//if it hits the end of the rright and it is null
                    //updated=true;
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
        Elem current = root;
        
        boolean get = false;
        
        if ( current == null ) {
            throw new NoSuchElementException("Key not found");
            //get=true;
            //root = new Elem<E>( key);
        }

        while(!get){
            int test = key.compareTo(current.key); //compare key with current key
            if (test==0){//the same
                return current.count; //updates the counter if its the same
                //get=true;
                
            }else if(test<0){//less then
                if (current.left==null){ //if left is empty
                    throw new NoSuchElementException("Key not found");//if it hit the end and its null
                    //get=true;
                }else{
                    current = current.left;
                }
                
            }else{//greater then
                if (current.right==null){//if right is empty
                    throw new NoSuchElementException("Key not found");//if it hits the end of the rright and it is null
                    //get=true;
                }else{
                    current = current.right;
                }
            }
        }
        //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
        throw new NoSuchElementException("Key not found");
    }
  
    /** Returns the list of keys in order, according to the method compareTo of the key
     *  objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {

        LinkedList<String> listyList;
        listyList=new LinkedList<String>();

        return inOrderList(root,listyList);

        //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }

     /** Returns a LinkedList with the keys
     * 
     * @param list a LinkedList<String>
     * @param current an Elem
     * @return a LinkedList with the keys
     */
    private LinkedList<String> inOrderList(Elem current, LinkedList<String> list){
        
        LinkedList<String> newList;
        newList=list;

        if(current!=null){
            inOrderList(current.left, newList);
            newList.addLast(current.key);
            inOrderList(current.right, newList);
        }
        return newList;
    }

    /** Returns the values in the order specified by the method compareTo of the key
     *  objects.
     *
     *  @return the values
     */

    public long[] values() {
        long[] countArray;
        countArray=new long[size];
        int counter=0;
        return inOrderValue(root, countArray, counter);

       // throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

    }
    /** Returns a array with long values
     * @param counter, then counter of the whole thing
     * @param array an array on long numbers
     * @param current an Elem
     * @return an array with long values
     */
    private long[] inOrderValue(Elem current, long[] array, int counter){
        long[] countArray;
        countArray=new long[size];
        //int counter=0;

        if(current!=null){
            inOrderValue(current.left, countArray, counter);

            countArray[counter]=current.count;
            counter++;

            inOrderValue(current.right, countArray, counter);
        }

        return countArray;
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
