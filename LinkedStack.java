/** Implements the interface <code>Stack</code> using linked elements.
 *
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */
import java.util.Iterator;

public class LinkedStack<E> implements Stack<E>{

    // Objects of the class Elem are used to store the elements of the
    // stack.
    //Don't think these are actually needed, if we do it recursively I think I get it
   // private int count = 0;
 //   private int counter=1;
   // LinkedStack<E> a = new LinkedStack<E>(); //this is the original stack
//    LinkedStack<E> tmp = new LinkedStack<E>();
  //  LinkedStack<E> tmptwo = new LinkedStack<E>();
    //LinkedStack<E> b = new LinkedStack<E>(); //this is the original stack
//    LinkedStack<E> temp = new LinkedStack<E>();
  //  LinkedStack<E> temptwo= new LinkedStack<E>();
    //LinkedStack<E> tempthree = new LinkedStack<E>();
    E end;

    private int size;
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
        size++;
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
   
    public void roll() {
        if(top!=null){
            roll(pop());//start recursion
        }
    }

    private void roll(E b){
        if (top==null){
            push(b);
        }else{
            E temp = pop();
            roll(b);
            push(temp);
        }
    }
    /** Removes the botttom element. The element is inserted on the
     * top of the stack.
     */
	//ok so make new temp stack, iterate from second to end
	//push first onto temp
	//replace old with temp
    //jk that didn't work I'll try recursion and actually read the instructions f/n/o
    public void unroll() {
        end=null;
        if(top!=null){
            E temporary=pop();
            if(top==null){
                push(temporary);
            }else{
                push(temporary);
                unroller();
                push(end);
            }
        }
    }

   // E finally;
    private void unroller(){
        E now = pop();
        E temporary = pop();
        if(top!=null){
            push(temporary);
            unroller();
            push(now);
        }else{
            end=temporary;
            push(now);
        }
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
}
