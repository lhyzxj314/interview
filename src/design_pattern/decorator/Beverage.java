package design_pattern.decorator;

public abstract class Beverage {
  protected String description = "xx饮料";
  
  public String getDescription() {
    return description;
  }
  public abstract float cost();
}
