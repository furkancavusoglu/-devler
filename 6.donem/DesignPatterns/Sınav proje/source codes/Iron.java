public class Iron implements Material{
    Shape shape;
    double density=7.784;

    public Iron(Shape shape) {
        this.shape=shape;
    }
    public double calculateMass() {
        return shape.calculateArea()*density;
    }

}
