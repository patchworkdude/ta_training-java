package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int[] elements;
    int position;
    int capacity;
    boolean run;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public boolean addElement(int element){
        if (element > 0 && !run && capacity != 0) {
            elements[position++] = element;
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
