package map.task.model;

public enum Faculty {
    MATH, PHYSICS, PHILOSOPHY, ENGLISH;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
