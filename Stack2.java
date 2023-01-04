public interface Stack2 extends Container{
    
    void push(Comparable a);
    Comparable pop();
    Comparable top();
}

class EmptyStackException extends RuntimeException{}
