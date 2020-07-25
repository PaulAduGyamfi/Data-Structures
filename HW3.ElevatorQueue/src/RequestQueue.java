import java.util.LinkedList;

public class RequestQueue<T> extends LinkedList<T> {
    LinkedList<T> Queue;
    public RequestQueue(){
        this.Queue = new LinkedList<>();
    }

    public void enqueue(T request){
        this.Queue.addLast(request);
    }

    public void dequeue(){
        this.Queue.removeFirst();
    }

    public int size(){
        return this.Queue.size();
    }

    public boolean isEmpty(){
        return this.Queue.isEmpty();
    }

}
