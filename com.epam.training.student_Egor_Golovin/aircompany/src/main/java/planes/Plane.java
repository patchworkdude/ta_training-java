package planes;

import java.util.Objects;

abstract public class Plane {
    private final String MODEL;
    private final int MAX_SPEED;
    private final int MAX_FLIGHT_DISTANCE;
    private final int MAX_LOAD_CAPACITY;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        MODEL = model;
        MAX_SPEED = maxSpeed;
        MAX_FLIGHT_DISTANCE = maxFlightDistance;
        MAX_LOAD_CAPACITY = maxLoadCapacity;
    }

    public String getModel() {
        return MODEL;
    }

    public int getMaxSpeed() {
        return MAX_SPEED;
    }

    public int getMaxFlightDistance() {
        return MAX_FLIGHT_DISTANCE;
    }

    public int getMaxLoadCapacity() {
        return MAX_LOAD_CAPACITY;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + MODEL + '\'' +
                ", maxSpeed=" + MAX_SPEED +
                ", maxFlightDistance=" + MAX_FLIGHT_DISTANCE +
                ", maxLoadCapacity=" + MAX_LOAD_CAPACITY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return MAX_SPEED == plane.MAX_SPEED &&
                MAX_FLIGHT_DISTANCE == plane.MAX_FLIGHT_DISTANCE &&
                MAX_LOAD_CAPACITY == plane.MAX_LOAD_CAPACITY &&
                Objects.equals(MODEL, plane.MODEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MODEL, MAX_SPEED, MAX_FLIGHT_DISTANCE, MAX_LOAD_CAPACITY);
    }
}
