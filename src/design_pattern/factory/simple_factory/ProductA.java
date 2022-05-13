package design_pattern.factory.simple_factory;

public class ProductA implements Product {
    @Override
    public void printProductName() {
        System.out.println("大疆无人机");
    }
}
