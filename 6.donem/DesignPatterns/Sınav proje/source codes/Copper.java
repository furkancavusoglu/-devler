public class Copper implements Material{
    Shape shape;
    double density=8.96;

    public Copper(Shape shape) {
        this.shape= shape;
    }

    public double calculateMass() {
        return shape.calculateArea()*density;
    }
}
