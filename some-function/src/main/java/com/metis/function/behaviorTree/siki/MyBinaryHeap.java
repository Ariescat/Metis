package com.metis.function.behaviorTree.siki;

public class MyBinaryHeap<AnyType extends Comparable<? super AnyType>> {

    public MyBinaryHeap() {
        clear(DEFAULT_CAPACITY);
    }

    public int size() {
        return currentSize;
    }

    public void clear(int capacity) {
        array = (AnyType[]) new Comparable[capacity];
    }

    //使用上滤，这种方法插入值
    public void add(AnyType value) {

        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);

        int hole = ++currentSize;
        for (; hole > 1 && value.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = value;

    }

    //返回最小值
    public AnyType findMin() {
        return array[1];

    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public AnyType deleteMin() {
        if (isEmpty()) {
            System.out.println("二叉堆为空");
            return null;
        }
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public void makeEmpty() {
        array = (AnyType[]) new Comparable[1];

    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    private AnyType[] array;

    // 使用下潜法将大值放下去，小值放上来。
    private void percolateDown(int hole) {
        int child;
        AnyType temp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {

            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(temp) < 0)
                array[hole] = array[child];
            else
                break;

        }
        array[hole] = temp;

    }

    private void enlargeArray(int newSize) {
        AnyType[] newarray;
        newarray = (AnyType[]) new Comparable[newSize];
        int i = 0;
        for (AnyType item : array)
            newarray[i++] = item;

        array = newarray;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < currentSize; i++)
                if (array[i] == null)
                    return i;
        } else {
            for (int i = 0; i < currentSize; i++)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyBinaryHeap test = new MyBinaryHeap();
        test.add(4);
        test.add(3);
        test.add(2);
        test.add(1);
        test.deleteMin();
        System.out.println(test.findMin());
    }

}