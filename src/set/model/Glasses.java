package set.model;

import java.util.Objects;

public class Glasses implements Comparable<Glasses> {
    private String brand;
    private boolean isOptical;
    private double price;

    public Glasses(String brand, boolean isOptical, double price) {
        this.brand = brand;
        this.isOptical = isOptical;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glasses glasses = (Glasses) o;
        return isOptical == glasses.isOptical &&
                Double.compare(glasses.price, price) == 0 &&
                Objects.equals(brand, glasses.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, isOptical, price);
    }

    @Override
    public int compareTo(Glasses glasses) {
        return (int) (this.price - glasses.price);
    }
}
