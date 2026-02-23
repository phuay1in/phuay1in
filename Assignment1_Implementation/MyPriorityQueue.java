import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<T> implements PriorityQueueADT<T> {

    private T[] data;
    private int size;
    private Comparator<T> comparator;

    public MyPriorityQueue(Comparator<T> comparator) {
        this(10, comparator);
    }

    public MyPriorityQueue(int capacity, Comparator<T> comparator) {
        if (capacity <= 0 || capacity > MAX_CAPACITY)
            throw new IllegalArgumentException();
        if (comparator == null)
            throw new IllegalArgumentException();

        data = (T[]) new Object[capacity];
        size = 0;
        this.comparator = comparator;
    }

    @Override
    public void enqueue(T item) {
        if (item == null)
            throw new IllegalArgumentException("Illegal Argument");

        if (size == data.length)
            throw new IllegalStateException("PriorityQueue is full");

        int i = size - 1;

        while (i >= 0 && comparator.compare(item, data[i]) < 0) {
            data[i + 1] = data[i];
            i--;
        }

        data[i + 1] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("No elements to dequeue");

        T item = data[0];

        for (int i = 1; i < size; i++)
            data[i - 1] = data[i];

        data[size - 1] = null;
        size--;

        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("No elements to peek");

        return data[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++)
            arr[i] = data[i];
        return arr;
    }
}