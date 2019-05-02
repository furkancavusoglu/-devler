public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        description="Circle: radius="+radius;
        this.radius= radius;
    }

    public double calculateArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public String printProperties() {
        return description;
    }
    @Override
    public String toString() {
        return "Circle";
    }
    public String getShapeProperty() {
        return super.description;
    }



}
