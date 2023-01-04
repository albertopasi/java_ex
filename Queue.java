
public interface Queue extends Container{
	void enqueue(Object obj);
	Object dequeue();
	Object getFirst();
}
class EmptyQueueException extends RuntimeException { }
class FullQueueException extends RuntimeException { }