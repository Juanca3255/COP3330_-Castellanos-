public class Sphere extends Shape3D{
    double radius;

    public Sphere(double r){
        radius=r;
    }
    public String getName(){
        return "sphere";
    }
    public double getArea(){
        return 4*Math.PI*(radius*radius);
    }
    public double getVolume(){
        return ((Math.pow(radius,3))*Math.PI*4)/3;
    }
}
