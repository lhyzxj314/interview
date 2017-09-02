package design_pattern.decorator;

public class TestClient {
  public static void main(String[] args) {
    Beverage b = new DarkRoast();
    System.out.println(b.getDescription() + " $" + b.cost());
    
    Beverage b2 = new Mocha(b);
    b2 = new Whip(b2);
    System.out.println(b2.getDescription() + " $" + b2.cost());
  }
}
