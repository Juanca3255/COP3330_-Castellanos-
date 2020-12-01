import java.io.IOException;
import java.util.Scanner;

public class Selection {
    public static void main(String[]args) throws IOException {
        Scanner input=new Scanner(System.in);
        select();
        int selection=input.nextInt();
            if(selection==1){
                TaskApp.main(null);
            }
            else
                if(selection==2){
                    ContactApp.main(null);
                }
    }
public static void select(){
    System.out.println("Select Your Application");
    TaskApp.dash();
    System.out.println("1) task list");
    System.out.println("2) contact list");
    System.out.println("3) quit");
}
}
