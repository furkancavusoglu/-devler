public class Square extends Shape{
    private double length;

    public Square(double length) {
        description= "Square: length="+length;
        this.length= length;
    }

    public double calculateArea() {
        return length*length;
    }

    @Override
    public String printProperties() {
        return description;
    }
    @Override
    public String toString() {
        return "Square";
    }
    public String getShapeProperty() {
        return super.description;
    }

}
