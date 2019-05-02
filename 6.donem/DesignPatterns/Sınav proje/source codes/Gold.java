public class Gold implements Material{
    Shape shape;
    double density=19.32;

    public Gold(Shape shape) {
        this.shape= shape;
    }
    public double calculateMass() {
        return shape.calculateArea()*density;
    }

}
