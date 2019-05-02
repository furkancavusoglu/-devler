public class Light extends PropertyDecorator{
    Shape shape;
    int light;

    public Light(Shape shape,int light) {
        this.shape= shape;
        this.light= light;
    }

    @Override
    public String printProperties() {
        shape.description=  shape.printProperties()+" light: "+light;
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
