import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> data){
        double average=0;
        for(int i=0; i<data.size(); i++){
            average=average+data.get(i).BMI_score;
        }
        System.out.println("Average BMI score of all recorded data: "+average);
    }
    public static void displayBmiInfo(BodyMassIndex bmi){
            System.out.println("Your BMI info is : ");
            System.out.println("BMI Score: "+bmi.BMI_score);
            System.out.println("BMI category: "+bmi.BMI_category);
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
    }

    public static boolean moreInput() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Y if more input, enter N if done.");
        String answer= in.nextLine();
        if(answer.equals("Y")){
            return true;
        }
        else
            return false;
    }

    public static double getUserHeight(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your height in inches (only positive non-zero values accepted) : ");
        double answer=in.nextDouble();
        String clean=in.nextLine();
        while(answer<=0){
            System.out.println("Negative numbers or zero were entered. Please try again.");
            System.out.println("Enter your height in inches (only positive values accepted) : ");
            answer=in.nextDouble();
            clean=in.nextLine();
        }
        System.out.println("-------------------------------");
        return answer;
     }
    public static double getUserWeight(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your weight in pounds (only positive non-zero values accepted) : ");
        double answer=in.nextDouble();
        String clean=in.nextLine();
        while(answer<=0){
            System.out.println("Negative numbers or zero were entered. Please try again.");
            System.out.println("Enter your weight in pounds (only positive values accepted) : ");
            answer=in.nextDouble();
            clean=in.nextLine();
        }
        System.out.println("-------------------------------");
            return answer;

    }
}