public class QueueByStackTester {
    public static void main(String[] args){
        Queue q1=new ArrayQueue();
        Queue q2=new QueueByStack();
        q1.enqueue(2);
        q1.enqueue("pippo");
        q1.getFirst();
        q1.dequeue();
        q1.enqueue("pluto");
        q1.getFirst();

        q2.enqueue(2);
        q2.enqueue("pippo");
        q2.getFirst();
        q2.dequeue();
        q2.enqueue("pluto");
        q2.getFirst();

        if(compareQueue(q1, q2)){
            System.out.println("Collaudo riuscito");
        }else{
            System.out.println("Collaudo non riuscito");

        }
    }

    public static boolean compareQueue(Queue a, Queue b){
        Queue temp1=new ArrayQueue();
        Queue temp2=new ArrayQueue();
        boolean uguali=true;
        while(!temp1.isEmpty() && !temp2.isEmpty() && uguali){
            Object x1=new Object();
            x1=a.dequeue();
            Object x2=new Object();
            x2=b.dequeue(); 
            uguali= (x1==null && x2==null) || (x1!=null && x2!=null && x1.equals(x2));
        }
        while(!a.isEmpty() || !b.isEmpty()){
            uguali=false;
        }
        while(!temp1.isEmpty()){
            a.enqueue(temp1.dequeue());
        }
        while(!temp2.isEmpty()){
            b.enqueue(temp2.dequeue());
        }
        return uguali;
    }
}
