package design_pattern.proxy;

public class ProxyImage implements Image {

  private String fileName;
  private Image realImage;
  
  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }
  
  @Override
  public void display() {
    if (realImage == null) {
      realImage = new RealImage(this.fileName);
    }
    realImage.display();
  }

}
