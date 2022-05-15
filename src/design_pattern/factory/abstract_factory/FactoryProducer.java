package design_pattern.factory.abstract_factory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String factoryName) {
		if (factoryName == "COLOR")
			return new ColorFactory();
		else if (factoryName == "SHAPE")
			return new ShapeFactory();
		return null;
	}
}
