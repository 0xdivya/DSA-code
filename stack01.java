import java.util.*;

public class stack01 {
    int stack[];
    int top;    
    int size; 

    public  stack01 (int stackSize){
        stack = new int[stackSize];
        size = stackSize;
        top = -1;
    }

    //insert
    public void push(int element){
        if(top==size-1){
            System.out.println("Stack is full - overloaded");
            return;
        }
        top++;
        stack[top] = element;
    }

    //is empty
    public boolean isEmpty(){
        return top ==-1;
    }

    //size
    public int size(){
        return top+1;
    }

    //peek
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    //pop
    public int pop(){
        int val = peek();
        if(val!=Integer.MIN_VALUE){
            top--;
        }
        return val;
    }

    public void printStack(){
        System.out.println("Printing stack elements:");
        for(int i=0;i<=top;i++){
            System.out.println(stack[i]);
            if(i!=top){
                System.out.println(" , ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
         int n=5; // take user input
        stack01 stack = new stack01(n);
        System.out.println("isEmpty:"+  stack.isEmpty());
        stack.push(9);
        stack.printStack();
        stack.push(1);
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.push(5);
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.push(2);
        stack.printStack();
        stack.push(6);
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println("size:"+  stack.size());
        System.out.println("isEmpty:"+  stack.isEmpty());
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println("peek:"+  stack.peek());

        //java collection
        Stack<Integer> st = new Stack<>();
        st.peek();
        st.push(7);
        st.pop();
        st.size();
        st.isEmpty();
    }
}
