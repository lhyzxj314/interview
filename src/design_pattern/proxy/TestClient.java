package design_pattern.proxy;

public class TestClient {
  public static void main(String[] args) {
    Image image = new ProxyImage("图片.jpg");
    image.display();
    System.out.println("");
    image.display();
  }
}
