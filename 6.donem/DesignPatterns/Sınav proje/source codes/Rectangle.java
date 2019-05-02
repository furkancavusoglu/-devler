public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        description= "Rectangle: length="+length+" width="+width;
        this.length=length;
        this.width= width;
    }

    public double calculateArea() {
        return width*length;
    }

    @Override
    public String printProperties() {
        return description;
    }
    @Override
    public String toString() {
        return "Rectangle";
    }
    public String getShapeProperty() {
        return super.description;
    }

}
