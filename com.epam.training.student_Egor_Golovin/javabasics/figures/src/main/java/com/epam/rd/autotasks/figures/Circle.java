package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    double radius;
    double Ax, Ay;

    public Circle(Point A, double radius) {
        this.radius = radius;
        Ax = A.getX();
        Ay = A.getY();
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String pointsToString() {
        return String.format("(%.1f,%.1f)", Ax, Ay);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(Ax - radius, Ay);
    }
}
