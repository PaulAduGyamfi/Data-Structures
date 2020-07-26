import java.util.LinkedList;

public class RequestQueue<Request> extends LinkedList<Request> {
    LinkedList<Request> Queue;
    private final int MAX = 1;
    int size = 0;

    public RequestQueue(){
        this.Queue = new LinkedList<>();
    }

    public void enqueue(Request request) throws QueueFullException{
//        if(Queue.size() >= 1){
//            throw new QueueFullException();
//        }
        this.Queue.add(request);
        size++;
    }

    public Request dequeue() throws QueueEmptyException{
        if(Queue.size() == 0){
            throw new QueueEmptyException();
        }

        size--;
        return this.Queue.removeFirst();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return this.Queue.size() == 0;
    }

}
