public class Cube extends Shape3D{
    double length;

    public Cube(double l){
        length=l;
    }

    public double getArea(){
        return length*length*6;
    }
    public String getName(){
        return "cube";
    }
    public double getVolume(){
        return length*length*length;
    }
}