public class QueueByStack implements Queue
{
    public QueueByStack()
    {  s = new ArrayStack(); }

    public void enqueue(Object obj)
    {   Stack temp=new ArrayStack();
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        s.push(obj);
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
    }

    public Object getFirst()
    {  try{
           return s.top();
       } 
       catch(EmptyStackException e){
           throw new EmptyQueueException();
       }
    }

    public Object dequeue()
    {  
        try{
            return s.pop();
        } 
        catch(EmptyStackException e){
            throw new EmptyQueueException();
        }
    }

    public void makeEmpty()
    {  s.makeEmpty(); }

    public boolean isEmpty()
    {  return s.isEmpty(); }

    //campi di esemplare
    private Stack s;
}
