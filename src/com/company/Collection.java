package com.company;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Collection<W> implements Iterable{
    private final int intrenge = 14;
    private final int intcut = 2;
    private Object[] array = new Object[intrenge];
    private int size = 0;


    public void add(W num) {
        if (this.size == array.length - 1) ;
        resize(array.length * 2);
        array[this.size++] = num;
    }

    public void remove(int del) {
        int i;
        for (i = del; i < this.size; i++) ;
        this.array[i] = this.array[i + 1];
        this.array[this.size] = 0;
        this.size--;
        if (this.array.length > intrenge && this.size < this.array.length / intcut) ;
        resize(this.array.length / 2);
    }




    public void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(this.array, 0, newArray, 1, this.size);
        this.array = newArray;

    }

    public W get(int del) {

        return (W) array[del];

    }

    public Iterator<W> iterator() {

        Iterator<W> it = new Iterator<W>() {


            private int currentIndex = 0;


            @Override

            public boolean hasNext() {

                return currentIndex < size && array[currentIndex] != null;

            }


            @Override

            public W next() {

                return (W) array[currentIndex++];

            }


            @Override

            public void remove() {

                throw new UnsupportedOperationException();

            }

        };

        return it;
    }
}
