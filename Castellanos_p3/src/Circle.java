public class Circle extends Shape2D{
    double radius;

    public Circle(double r){
        radius=r;
    }
    public String getName(){
        return "circle";
    }
    public double getArea(){
        return 2*Math.PI*radius;
    }

}
