package design_pattern.factory.abstract_factory;

public class AbstractFactoryDemo {
	
	public static void main(String[] args) {
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		shapeFactory.getShape("circle").draw();
		colorFactory.getColor("red").fill();
	}

}
