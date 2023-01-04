public interface Queue2 extends Container{
	void enqueue(Comparable obj);
	Comparable dequeue();
	Comparable getFirst();
}
class EmptyQueueException extends RuntimeException { }
class FullQueueException extends RuntimeException { }