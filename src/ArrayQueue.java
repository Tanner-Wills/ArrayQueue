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
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if(data == null){
            throw new IllegalArgumentException("Can't add null data to the Queue!");
        }
        //resize if needed
        if((size + 1) > backingArray.length){
            T[] expandArray =  (T[]) new Object[backingArray.length * 2];
            for(int i = 0; i<size; i++){
                expandArray[i] = backingArray[i];
            }
            backingArray = expandArray;
        }
        //add data to backingArray
        backingArray[size+front] = data;
        size += 1;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if(size == 0){
            throw new IllegalArgumentException("Can't dequeue from empty list! No items in the queue!");
        }
        T removeFront = backingArray[front];
        backingArray[front] = null;
        front += 1;
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