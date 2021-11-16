package Generics;

import java.util.Arrays;
import java.util.List;

public class WildCardExample<T extends Number> {
    private Object[] data;
    private int size = 0;
    private static int DEFAULT_SIZE = 10;

    public String getData() {
        return Arrays.toString(data);
    }

    public void wildCard(List<? extends Number> list) {
        // do something
    }

    public WildCardExample() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T elem) {
        if (isFull()) {
            resize();
        }
        data[size++] = elem;
    }

    private void resize() {
        Object[] temp = new Object[DEFAULT_SIZE * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        if (size == DEFAULT_SIZE) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "{" + " data='" + getData() + "'" + ", size='" + getSize() + "'" + "}";
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        for (int i = 0; i < 14; i++) {
            list.add(i * 2);
        }

        System.out.println(list);

    }
}
