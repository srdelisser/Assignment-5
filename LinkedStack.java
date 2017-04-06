/** Implements the interface <code>Stack</code> using linked elements.
 *
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */
import java.util.Iterator;

public class LinkedStack<E> implements Stack<E>{

    // Objects of the class Elem are used to store the elements of the
    // stack.
    
    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Reference to the top element
    
    private Elem<E> top;

    /** Returns <code>true</code> if this stack is empty, and
     * <code>false</code> otherwise.
     *
     * @return <code>true</code> if this stack is empty, and
     * <code>false</code> otherwise.
     */

    public boolean isEmpty() {
        return top == null;
    }

    /** Inserts an element onto the stack.
     *
     * @param value the element to be inserted
     */

    public void push(E value) {

	if (value == null) {
	    throw new NullPointerException();
	}
	
        top = new Elem<E>(value, top);
    }

    /** Returns the top element, without removing it.
     *
     * @return the top element
     */

    public E peek() {

	// pre-condition: the stack is not empty
	
        return top.value;
    }

    /** Removes and returns the top element.
     *
     * @return the top element
     */

    public E pop() {

	// pre-condition: the stack is not empty
	
        E saved = top.value;
        top = top.next;
        return saved;

    }

    /** Removes the top element of the stack. The element inserted at
     * the bottom of the stack.
     */
	//not sure best way to go about this
	//start by poping the top, adding to new temp stack, iterating over remaining stack to add to temp
	//then replace old stack with temp stack
    //NONE OF THIS WORKS JUST IGNORE IT FOR NOW ILL FIGURE IT OUT EVENTUALLY
    public void roll() {
        LinkedStack<E> a = new LinkedStack<E>(); //this is the original stack
        a=this;
        LinkedStack<E> tmp = new LinkedStack<E>(); //this will be the new stack
        LinkedStack<E> tmptwo = new LinkedStack<E>();

        if(top==null){
	       throw new UnsupportedOperationException("Invalid operation for linked stack. Method roll.");
        }else{
            if(tmptwo==null){//if tmp is empty then take the top element of a and make it the bottom element of tmp
                tmptwo.push(a.pop());
            }else{//once that element has been added, want to go through a from bottom to top
                while(top!=null){
                    tmp.push(a.pop());
                }
            }
        }
        tmp.push(tmptwo.pop());
        a=tmp;
        tmp=null;
        tmptwo=null;
    }

    /** Removes the botttom element. The element is inserted on the
     * top of the stack.
     */
	//ok so make new temp stack, iterate from second to end
	//push first onto temp
	//replace old with temp
    public void unroll() {
        LinkedStack<E> a = new LinkedStack<E>(); //this is the original stack
        a=this;
        LinkedStack<E> tmp = new LinkedStack<E>(); //this will be the new stack
        LinkedStack<E> tmptwo = new LinkedStack<E>();
        LinkedStack<E> tmpthree = new LinkedStack<E>();
        if (top==null){
	       throw new UnsupportedOperationException("Invalid operation for linked stack. Method unroll.");
	   }else{
            int count = 0;
            while(top!=null){
                tmp.push(a.pop());
            }
            if (tmptwo==null && count == 0){
                tmptwo.push(tmp.pop());
                count = 1;
            }
            tmpthree.push(tmptwo.pop());
            while(tmp!=null){
                tmpthree.push(tmp.pop());
            }
        }
       a=tmpthree;
       tmp=null;
       tmptwo=null;
       tmpthree=null;
    }

    /** Returns a string representation of the stack.
     *
     * @return a string representation
     */

    @Override public String toString() {
	StringBuffer stackStr = new StringBuffer("{");

	Elem<E> current = top;
	
	while (current != null) {
	    stackStr.append(current.value);
	    if (current.next != null) {
		stackStr.append(",");
	    }
	    current = current.next;
	}
	stackStr.append("}");

	return stackStr.toString();
    }
    public static void main (String args[]){
        Stack<String> s ;
        s = new LinkedStack<String>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");
        System.out.println(s);
        s.roll();
        s.roll();
        System.out.println(s);
    }
}
