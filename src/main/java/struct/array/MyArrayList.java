package struct.array;


/**
 * 数组列表实现：
 *
 * 1、相关题目
 */
public class MyArrayList<T> {

    private final static int DEFAULT_CAPACITY = 10;

    // 属性field
    private Object[] elements;

    private int capacity;

    private int size;

    // 构造器constructor
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("capacity value must be positive");
        }
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        this.elements = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    // 方法
    public void add(int index, T value) {
        rangeCheckForAdd(index);
        // resize
        if (size == capacity) {
            resize(2 * size);
        }
        size++;
        for (int i = size - 1; i > index; i--) {
            // maybe out of index
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
    }

    public void add(T value) {
        add(size, value);
    }

    public T remove(int index) {
        rangeCheck(index);
        T result = (T) elements[index];
        size--;
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size] = null;
        return result;
    }

    // 删除所有值为value的元素
    public void removeByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
            }
        }

    }

    public void set(int index, T value) {
        rangeCheck(index);
        elements[index] = value;
    }

    public T get(int index) {
        rangeCheck(index);
        return (T) elements[index];
    }

    public int getFirstElementByValue(int value) {
        return 0;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // dynamic grow
    private void resize(int capacity) {
        Object[] newElements = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        this.capacity = capacity;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException(String.format("The index is invalid, the index: %d", index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException(String.format("The index is invalid for add, the index: %d", index));
        }
    }

}
