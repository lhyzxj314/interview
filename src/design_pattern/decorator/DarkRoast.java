package design_pattern.decorator;

public class DarkRoast extends Beverage {

  public DarkRoast() {
    description = "DarkRoast";
  }
  @Override
  public float cost() {
    return 1.99f;
  }

}
