

public class ArrayQueue implements Queue{
	private Object[] v;
	private int front;
	private int back;
	private static final int INITSIZE=10;
	
	public ArrayQueue() {
		v=new Object[INITSIZE];
		makeEmpty();
	}
	public void makeEmpty() {
		front=back=0;
	}
	public boolean isEmpty() {
		return front==back;
	}
	protected int increment(int index) {
		return (index+1)%v.length;
	}
	public void enqueue(Object com) {
		if(com==null) throw new IllegalArgumentException();
		if(increment(back)==front) v=resize();
		v[back]=com;
		back++;
	}
	public Object[] resize() {
		Object[] a2=new Object[v.length*2];
		int temp=0;
		if(back<front) {
			System.arraycopy(v, front, a2, 0, v.length-front);
			System.arraycopy(v, 0, a2, v.length-front , back);
			temp=v.length-front+back;
		}else if(back>front){
			System.arraycopy(v, front, a2, 0, back-front);
			temp=back-front;
		}else {
			throw new EmptyQueueException();
		}
		front=0;
		back=temp;
		return a2;
	}
	public Object getFirst() {
		if(isEmpty()) throw new EmptyQueueException();
		return v[front];
	}
	public Object dequeue() {
		Object obj=getFirst();
		front=increment(front);
		return obj;
	}
	
}
