public class StackByQueue implements Stack{
    private Queue q;

    public StackByQueue()
    {  q = new ArrayQueue(); }

    public void push(Object obj)
    {   Queue temp=new ArrayQueue();
        while(!q.isEmpty()){
            temp.enqueue(q.dequeue());
        }
        q.enqueue(obj);
        while(!temp.isEmpty()){
            q.enqueue(temp.dequeue());
        }
    }

    public Object top()
    {   try{
            return q.getFirst(); 
        }
        catch(EmptyQueueException e){
            throw new EmptyStackException();
        }
    }

    public Object pop()
    {  try{
            return q.dequeue(); 
        }
        catch(EmptyQueueException e){
            throw new EmptyStackException();
        }
    }

    public void makeEmpty()
    {  q.makeEmpty(); }

    public boolean isEmpty()
    {  return q.isEmpty(); }

    
}
