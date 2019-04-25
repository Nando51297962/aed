import java.util.Stack;

public class Stqueue <E>{
    
    private Stack<E> stackFront;
    private Stack<E> stackBack;
    
    public Stqueue() {
        stackFront = new Stack<>();
        stackBack = new Stack<>();
    }
    
    public boolean isEmpty() {
        return stackFront.empty() && stackBack.empty();
    }
    
    public void push(E elem) {
        if(stackFront.capacity()==0) {
            stackFront.setSize(stackFront.size()*2);
        }
        stackFront.push(elem);
    }
    
    public void pop() {
        if(!stackFront.empty()) {
            stackFront.pop();
        } else if(!stackBack.empty()) {
            stackBack.remove(0);
        }
    }
    
    public void enqueue(E elem) {
        if(stackBack.capacity()==0) {
            stackBack.setSize(stackBack.size()*2);
        }
        stackBack.push(elem);
    }
    
}
