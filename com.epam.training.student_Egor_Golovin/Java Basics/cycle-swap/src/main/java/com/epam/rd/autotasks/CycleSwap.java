package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length != 0) {
            int[] copyArr = new int[array.length];
            System.arraycopy(array, 0, copyArr, 0, array.length);
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = copyArr[array.length - 1];
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length != 0) {
            int[] copyArr = new int[array.length];
            System.arraycopy(array, 0, copyArr, 0, array.length);
            System.arraycopy(array, 0, array, shift, array.length - shift);
            System.arraycopy(copyArr, array.length - shift, array, 0, shift);
        }
    }
}
