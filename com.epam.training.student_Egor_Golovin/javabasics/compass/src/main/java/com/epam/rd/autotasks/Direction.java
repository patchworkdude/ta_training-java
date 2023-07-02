package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45) , E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public final int degrees;

    public int getDegrees() {
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        for (Direction direction: Direction.values()) {
            if (Direction.reduce(degrees) == direction.degrees) { return direction; }
        } return null;
    }

    public static Direction closestToDegrees(int degrees) {
        for (int i = 0; i < 45; i++) {
            for (Direction direction: Direction.values()) {
                if (Direction.reduce(degrees - i) == direction.degrees
                || Direction.reduce(degrees + i) == direction.degrees) { return direction; }
            }
        } return null;
    }

    public Direction opposite() {
        switch (this) {
            case N: return S;
            case NE: return SW;
            case E: return W;
            case SE: return NW;
            case S: return N;
            case SW: return NE;
            case W: return E;
            case NW: return SE;
        } return null;
    }

    public int differenceDegreesTo(Direction direction) {
        return Math.abs(direction.getDegrees() - this.degrees) % 270; //bad test coverage
    }

    public static int reduce(int degrees) {
        return (360 + degrees) % 360;
    }
}
