import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndex {
    public double height=0;
    public double weight = 0;
    public double BMI_score=0;
    public String BMI_category="";

    public BodyMassIndex(double h, double w){
        this.height=h;
        this.weight=w;
        calculateBMI();
        category();
    }
    public void calculateBMI (){
        this.BMI_score= (703*this.weight) / (this.height*this.height);
         this.BMI_score = BigDecimal.valueOf(this.BMI_score)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
    public void category(){
        if(this.BMI_score<=18.5){
            BMI_category="Underweight";
        }
        else if(this.BMI_score > 18.5 && this.BMI_score<=24.9){
            BMI_category="Normal weight";
        }
        else if(this.BMI_score >=25 && this.BMI_score<=29.9){
            BMI_category="Overweight";
        }
        else
            BMI_category="Obesity";
    }

}
