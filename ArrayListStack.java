import java.*;
public class ArrayListStack<E> implements Stack<E>{


    private ArrayList<E> _stack;
    private int _capacity;
    private int _height;

    private final static int CAPACITY = 1000;

    public ArrayListStack(int capacity){
	_capacity = capacity;
	_stack = new ArrayList<E>;
	_height = 0;
    }
    
    public ArrayListStack(){
	this(CAPACITY);
    }

    public E peek() throws EmptyStackException{
	if (empty())
	    throw new EmptyStackException("Stack Empty");
	return _stack[_height - 1];
    }

    public void push(E element) throws FullStackException{
	if (size() == _capacity)
	    throw new FullStackException("Full Stack");
	_stack[_height++] = element;
    }


    public E pop() throws EmptyStackException{
	if (empty())
	    throw new EmptyStackException("Stack Empty");
	E ans = peek();
	_stack[--_height] = null;
	return ans;
    }

    public int size(){
	return _height;
    }
    
    public boolean empty(){
	return size() == 0;
    }


    public String toString(){
	String ans ="[";
	if (size() > 0) ans += _stack[0];
	if (size() > 1) 
	    for (int i = 1; i < size(); i++)
		ans += ", " + _stack[i];
	ans += "]";
	return ans;
    }
public void transferTo(ArrayListStack<E> rhs){
	while(rhs._height != rhs._capacity && !empty()) rhs.push(pop());	
	  }

    public static void main(String[] args){
	ArrayListStack<Integer> s = new ArrayListStack<Integer>(10);
	ArrayListStack<Integer> r = new ArrayListStack<Integer>(10);
	System.out.println("Empty: " + s.empty());
	System.out.println(s);
	for (int i = 0; i < 10; i++){
	    s.push(i);
	    System.out.println("push: " + i + " " + s);
	}
	System.out.println("peek: " + s.peek());
	s.transferTo(r);
	 System.out.println(r);
	}


}
