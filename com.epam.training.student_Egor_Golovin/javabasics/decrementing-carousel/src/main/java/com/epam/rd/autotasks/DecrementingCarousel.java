package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int position;
    int capacity;
    static int[] elements;
    boolean run;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        position = 0;
        elements = new int[capacity];
    }

    public boolean addElement(int element){
        if (element > 0 && !run && capacity != 0) {
            elements[position] = element;
            position++;
            capacity--;
            return true;
        }
        return false;
    }

    public CarouselRun run() {
        if (run) {
            return null;
        }
        run = true;
        return new CarouselRun();
    }
}
