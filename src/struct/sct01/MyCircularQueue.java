package struct.sct01;

/**
 * 项目名称：leeCodeTran
 * 类名：MyCircularQueue
 * 描述：
 *
 * @author Administrator
 * 创建时间：2019-12-18 11:00
 **/
public class MyCircularQueue {
    private int[] cQueue;
    private int head;
    private int tail;
    private int len;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.cQueue = new int[k];
        this.head = -1;
        this.tail = -1;
        this.len = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        if(isEmpty()){
            head = 0;
        }

        tail = (tail+1)%len; // 减少其他代码需要判断是不是到数组的尾部
        cQueue[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head+1)%len;
//        cQueue[head] = -1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return cQueue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return cQueue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {

        return head==-1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        //尾指针在头指针之前
        return (tail+1)%len == head;
    }


    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(6);
        System.out.println(obj.enQueue(6));
        System.out.println(obj.Rear());
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(5));
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
        System.out.println(obj.Front());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());

    }
}
