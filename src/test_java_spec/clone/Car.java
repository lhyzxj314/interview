package test_java_spec.clone;

import java.io.Serializable;

public class Car implements Cloneable, Serializable {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    @Override
    public Car clone() {
        try {
            Car car = (Car) super.clone();
            return car;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
