package design_pattern.decorator;

public class Mocha extends CondimentDecorator {

  public Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public float cost() {
    return beverage.cost() + 0.20f;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Mocha";
  }


}
