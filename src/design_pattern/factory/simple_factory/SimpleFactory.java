package design_pattern.factory.simple_factory;

public class SimpleFactory {
    public static Product getProductA() {
        return new ProductA();
    }

    public static Product getProductB() {
        return new ProductB();
    }

    public static Product getProductC() {
        return new ProductC();
    }
}
