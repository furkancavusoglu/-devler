public class Color extends PropertyDecorator{
    Shape shape;
    String color;


    public Color(Shape shape, String color) {
        this.shape= shape;
        this.color= color;
    }

    @Override
    public String printProperties() {
        shape.description=  shape.printProperties()+" color: "+color;
        return shape.description;
    }
    public String getShapeProperty() {
        return shape.description;
    }

    @Override
    public double calculateArea() {
        return shape.calculateArea();
    }




}