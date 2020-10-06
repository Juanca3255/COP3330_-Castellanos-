public class Square extends Shape2D{
    int length;

    public Square (int x){
        length=x;
    }
    public String getName(){
        return "square";
    }
    public double getArea(){
        return length*length;
    }
}
