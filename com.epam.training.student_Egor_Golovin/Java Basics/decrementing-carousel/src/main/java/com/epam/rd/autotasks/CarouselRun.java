package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.*;

public class CarouselRun {

    public int next() {
        if (isFinished()) return -1;
        if (position == elements.length) {
            position = 0;
        }
        if (elements[position] == 0) {
            position++;
            return next();
        }
        return elements[position++]--;
    }

    public boolean isFinished() {
       for (int element: elements) {
           if (element > 0) return false;
       }
       return true;
    }
}
