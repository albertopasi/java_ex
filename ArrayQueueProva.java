public class ArrayQueueProva implements Queue2{
    
    private Comparable[] v;
    private int front;
    private int back;
    private static final int INITSIZE=10;

    public ArrayQueueProva(){
        v=new Comparable[INITSIZE];
        makeEmpty();
    }

    public void makeEmpty(){
        front=back=0;
    }

    public boolean isEmpty(){
        return front==back;
    }

    protected int increment(int index){
        return (index+1)%v.length;
    }

    public Comparable[] resize() {
		Comparable[] a2=new Comparable[v.length*2];
		if(back<front){
            System.arraycopy(v, front, a2, 0, v.length-front);
            System.arraycopy(v, 0, a2, v.length-front, back);
            back=v.length-front+back;
            front=0;
        }else if(front<back){
            System.arraycopy(v, front, a2, 0, back-front);
            back=back-front;
            front=0;
        }else{
            throw new EmptyQueueException();
        }
        return a2;
	}

    public void enqueue(Comparable a){
        if(a==null) throw new IllegalArgumentException();
        if(increment(back)==front) v=resize();
        v[back]=a;
        back= increment(back);
    }

    public Comparable getFirst(){
        if(isEmpty()) throw new EmptyQueueException();
        return v[front];
    }

    public Comparable dequeue(){
        Comparable a=getFirst();
        front=increment(front);
        return a;
    }

}
