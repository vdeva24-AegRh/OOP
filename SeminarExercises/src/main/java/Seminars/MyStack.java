package Seminars;

import java.util.Collection;

public class MyStack<T> {
    private Object [] data;
    private int logLen;
    private int allocLen;

    public MyStack() {
        allocLen = 4;
        logLen = 0;
        data = new Object[allocLen];
    }
    public void add(T newElem) {
        if(logLen == allocLen) {
            allocLen *= 2;
            Object[] newData = new Object[allocLen];
            System.arraycopy(data , 0 , newData , 0 , data.length);
            data = newData;
        }
        data[logLen++] = newElem;
    }

    public T pop() {
        if(logLen == 0) {
            throw new IndexOutOfBoundsException("Stack Is Empty!");
        }
        return (T)data[--logLen];
    }
    public void addAll(Collection<T> newElems) {
        for(T elem: newElems) {
            add(elem);
        }
    }
    public int size() {
        return logLen;
    }
}
