import java.util.Arrays;

public class QueueTester {
    public static void main(String[] args) {

        ArrayQueue<Integer> testQueue = new ArrayQueue<>();


        testQueue.enqueue(5);
        testQueue.enqueue(4);
        testQueue.enqueue(3);
        testQueue.enqueue(2);
        testQueue.enqueue(1);
        System.out.println(Arrays.toString(testQueue.getBackingArray()));


        testQueue.dequeue();
        System.out.println("Size = " + testQueue.size());
        System.out.println(Arrays.toString(testQueue.getBackingArray()));

        testQueue.dequeue();
        System.out.println("Size = " + testQueue.size());
        System.out.println(Arrays.toString(testQueue.getBackingArray()));


        testQueue.enqueue(69);
        System.out.println(Arrays.toString(testQueue.getBackingArray()));

    }
}
