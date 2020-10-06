public class Pyramid extends Shape3D{
    double baseLength;
    double baseWidth;
    double height;

    public Pyramid(double l, double w, double h){
        baseLength=l;
        baseWidth=w;
        height=h;
    }
    public String getName(){
        return "pyramid";
    }
    public double getArea(){
        return (baseLength*baseWidth)+(baseLength*Math.sqrt((Math.pow((baseWidth/2),2))+Math.pow(height,2)))+(baseWidth*Math.sqrt((Math.pow((baseLength/2),2))+Math.pow(height,2)));
    }
    public double getVolume(){
        return (baseLength*baseWidth*height)/3;
    }
}
