import java.util.NoSuchElementException;

public class ArrayQueue<T> {

    public static final int INITIAL_CAPACITY = 9;

    //Instance Variables
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * Constructor
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
    */
    public void enqueue(T data) {
        if(data == null){
            throw new IllegalArgumentException("Can't add null data to the Queue!");
        }
        //resize if needed
        if((size + 1) > backingArray.length){
            T[] expandArray =  (T[]) new Object[backingArray.length * 2];
            for(int i = 0; i<size; i++){
                expandArray[i] = backingArray[(front + i)%backingArray.length];
            }
            backingArray = expandArray;
        }
        //add data to backingArray
        backingArray[size+front]%backingArray.length = data;
        front = 0;
        size += 1;
    }

    /**
     * Removes and returns the data from the front of the queue.
     */
    public T dequeue() {
        if(size == 0){
            throw new IllegalArgumentException("Can't dequeue from empty list! No items in the queue!");
        }
        T removeFront = backingArray[front];
        backingArray[front] = null;
        front = (front + 1)%backingArray.length;
        size -= 1;
        return removeFront;
    }

    /**
     * Returns the backing array of the queue.
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     */
    public int size() {

        return size;
    }
}