package design_pattern.factory.abstract_factory;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		} else if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();
		}
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}

	

}
