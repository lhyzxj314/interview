package design_pattern.decorator;

public abstract class CondimentDecorator extends Beverage {
  protected Beverage beverage;
  
  public abstract String getDescription(); 
}
