package set.model;

import java.util.Objects;

public class Coffee implements Comparable<Coffee> {
    private String name;
    private int gramsOfCoffee;
    private int gramsOfSugar;
    private boolean withSteamedMilk;
    private boolean withFrothedMilk;
    private boolean withWhiskey;
    private boolean withIceCream;

    public Coffee(String name, int gramsOfCoffee, int gramsOfSugar, boolean withSteamedMilk, boolean withFrothedMilk,
                  boolean withWhiskey, boolean withIceCream) {
        this.name = name;
        this.gramsOfCoffee = gramsOfCoffee;
        this.gramsOfSugar = gramsOfSugar;
        this.withSteamedMilk = withSteamedMilk;
        this.withFrothedMilk = withFrothedMilk;
        this.withWhiskey = withWhiskey;
        this.withIceCream = withIceCream;
    }

    @Override
    public int compareTo(Coffee coffee) {
        return this.gramsOfCoffee - coffee.gramsOfCoffee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return gramsOfCoffee == coffee.gramsOfCoffee &&
                gramsOfSugar == coffee.gramsOfSugar &&
                withSteamedMilk == coffee.withSteamedMilk &&
                withFrothedMilk == coffee.withFrothedMilk &&
                withWhiskey == coffee.withWhiskey &&
                withIceCream == coffee.withIceCream &&
                Objects.equals(name, coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gramsOfCoffee, gramsOfSugar, withSteamedMilk, withFrothedMilk,
                withWhiskey, withIceCream);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", gramsOfCoffee=" + gramsOfCoffee +"}";
    }
}
