package design_pattern.factory.simple_factory;

public class TestClient {
    public static void main(String[] args) {
        Product p1 = SimpleFactory.getProductA();
        Product p2 = SimpleFactory.getProductB();
        Product p3 = SimpleFactory.getProductC();

        p1.printProductName();
        p2.printProductName();
        p3.printProductName();
    }
}
