public class Contrast extends PropertyDecorator{
    Shape shape;
    int contrast;

    public Contrast(Shape shape, int contrast) {
        this.shape= shape;
        this.contrast= contrast;
    }

    @Override
    public String printProperties() {
        shape.description=  shape.printProperties()+" contrast:"+contrast;
        return shape.description;
    }

    @Override
    public double calculateArea() {
        return shape.calculateArea();
    }
    public String getShapeProperty() {
        return shape.description;
    }
}
