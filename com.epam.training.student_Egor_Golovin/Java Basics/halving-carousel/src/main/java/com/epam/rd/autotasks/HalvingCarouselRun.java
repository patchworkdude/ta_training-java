package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.elements;

public class HalvingCarouselRun extends CarouselRun {

    public int next() {
        if (isFinished()) return -1;
        if (position == elements.length) {
            position = 0;
        }
        if (elements[position] == 0) {
            position++;
            return next();
        }
        int result = elements[position];
        elements[position] = elements[position++] / 2;
        return result;
    }

    public boolean isFinished() {
        for (int element: elements) {
            if (element > 0) return false;
        }
        return true;
    }
}
