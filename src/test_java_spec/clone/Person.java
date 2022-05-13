package test_java_spec.clone;

import java.io.Serializable;

public class Person implements Cloneable, Serializable {
    private String name;
    private Car car;

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return this.name;
    }

    public Car getCar() {
        return this.car;
    }

    public String getString() {
        return "Name: " +  this.name +  "CarBrand:" + this.car.getBrand();
    }

    @Override
    public Person clone() {
        try {
            Person clone = (Person) super.clone();
            if (this.car != null) {
                clone.setCar(this.car.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
