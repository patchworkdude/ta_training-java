package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public boolean addElement(int element){
        if (element > 0 && !run && capacity != 0) {
            elements[position++] = element;
            capacity--;
            return true;
        }
        return false;
    }

    @Override
    public CarouselRun run() {
        if (run) {
            return null;
        }
        run = true;
        return new HalvingCarouselRun();
    }
}
