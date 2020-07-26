import java.util.LinkedList;
/**
 * This class represents a request queue where all the request are waiting to be completed,
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class RequestQueue<Request> extends LinkedList<Request> {
    LinkedList<Request> Queue;
    int size = 0;

    public RequestQueue(){
        this.Queue = new LinkedList<>();
    }

    /**
     *
     * @param request
     * request object to enter enter the queue
     */
    public void enqueue(Request request){
        this.Queue.add(request);
        size++;
    }

    /**
     *
     * @return
     * the request at the front of the queue
     * @throws QueueEmptyException
     * if the queue is empty
     */
    public Request dequeue() throws QueueEmptyException{
        if(Queue.size() == 0){
            throw new QueueEmptyException();
        }

        size--;
        return this.Queue.removeFirst();
    }

    /**
     *
     * @return
     * the size of the queue
     */
    public int size(){
        return size;
    }

    /**
     *
     * @return
     * true if the queue is empty else false
     */
    public boolean isEmpty(){
        return this.Queue.size() == 0;
    }

}
