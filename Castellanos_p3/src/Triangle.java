public class Triangle extends Shape2D{
    double base;
    double length;

    public Triangle(double x, double y){
        base=x;
        length=y;
    }
    public String getName(){
        return "triangle";
    }
    public double getArea(){
        return (0.5)*base*length;
    }
}
