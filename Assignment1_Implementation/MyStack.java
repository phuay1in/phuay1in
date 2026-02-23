import java.util.NoSuchElementException;

public class MyStack<T> implements StackADT<T> {

    private T[] data;
    private int size;

    public MyStack() {
        this(10);
    }

    public MyStack(int capacity) {
        if (capacity <= 0 || capacity > MAX_CAPACITY)
            throw new IllegalArgumentException();
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void push(T item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (size == data.length)
            throw new IllegalStateException();

        data[size++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException();

        T item = data[--size];
        data[size] = null;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();

        return data[size - 1];
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