import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        TaskList list;
        mainMenu();
        int num = input.nextInt();
        while (num != 3) {
            if (num == 1) {
                System.out.println("new task list has been created");
                list = new TaskList();
                operationMenu(list);
            }else
                if (num == 2) {
                    String name = file_read();
                    list = TaskList.loadFile(name);
                    if(list.getSize()==0){
                        //mainMenu();
                    }
                    else
                    operationMenu(list);
                }
                else
                    if (num == 3) {
                    break;
                }
                mainMenu();
                num = input.nextInt();
            }
    }

    public static void dash(){
        System.out.println("---------");
    }
    public static void mainMenu(){
        System.out.println("Main Menu");
        dash();
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");

    }
    public static void operationMenu(){
        System.out.println("List Operation Menu");
        dash();
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
    }
    public static String addTaskTitle(){
        Scanner input=new Scanner(System.in);
        System.out.println("Task title: ");
        String title2=input.nextLine();
        return title2;
    }
    public static String addTaskDescription(){
        Scanner input=new Scanner(System.in);
        System.out.println("Task description: ");
        String description2=input.nextLine();
        return description2;
    }
    public static String addTaskDate(){
        Scanner input=new Scanner(System.in);
        System.out.println("Task due date (YYYY-MM-DD): ");
        String date2=input.nextLine();
        return date2;
    }
    public static int editTask() {
        System.out.println("Which task will you edit? ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        return num;
    }
    public static String editTitle(int num){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a new title for task "+num+" : ");
        String title=input.nextLine();
        return title;
    }
    public static String editDescrip(int num){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a new description for task "+num+" : ");
        String description=input.nextLine();
        return description;
    }
    public static String editDate(int num){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a new task due date (YYYY-MM-DD) for task "+num+" : ");
        String date=input.nextLine();
        return date;
    }
    public static int removal(){
        Scanner input=new Scanner(System.in);
        System.out.println("Which task will you remove? ");
        int num=input.nextInt();
        return num;
    }
    public static int tobeCompleted(){
        Scanner input=new Scanner(System.in);
        System.out.println("Which task will you mark as completed? ");
        int num=input.nextInt();
        return num;
    }
    public static int tobeUnMarked(){
        Scanner input=new Scanner(System.in);
        System.out.println("Which task will you unmark as completed? ");
        int num=input.nextInt();
        return num;
    }
    public static int warning(int num, int size){
        int not=1;
        if(num==size || num>size || num<0){
            System.out.println("WARNING: invalid input for task. Task not found.");
            not=-1;
        }
        return not;
    }
    public static int inputCheckTitle(String t){
        int found=1;
        if(t.length()<1) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            found=-1;
        }
        return found;
    }
    public static int inputCheckDate(String d){
        int found=1;
        if(d.length()!=10 || d.indexOf('-')!=4 ||
                d.indexOf('-',6)!=7){
            System.out.println("WARNING: invalid due date; task not created");
            found=-1;
        }
        return found;
    }
    public static String file_write(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the filename to save as: ");
        String name=input.nextLine();
        return name;
    }
    public static String file_read(){
        Scanner input=new Scanner (System.in);
        System.out.println("Enter the filename to upload: ");
        String name=input.nextLine();
        return name;
    }
    public static void operationMenu(TaskList list) throws IOException {
        Scanner input = new Scanner(System.in);
        operationMenu();
        int menuNum;
        menuNum = input.nextInt();
        while (menuNum != 8) {
            if(menuNum==0 || menuNum==9){
                System.out.println("These input are not accepted. Please try again. ");
                operationMenu();
                menuNum=input.nextInt();
            }
            else
            if (menuNum == 1) {
                list.viewList();
                operationMenu();
                //System.out.println("In 1");
                menuNum= input.nextInt();
            }
            else
            if(menuNum==2){
                //System.out.println("In 2");
                TaskItem addition=new TaskItem();
                String title2=addTaskTitle();
                String description2=addTaskDescription();
                String due_date2=addTaskDate();
                int found1=inputCheckTitle(title2);
                int found2=inputCheckDate(due_date2);
                if(found1==1&&found2==1) {
                    addition.setTitle(title2);
                    addition.setDescription(description2);
                    addition.setDue_date(due_date2);
                    list.addItem(addition);
                }
                operationMenu();
                menuNum= input.nextInt();

            }else

            if(menuNum==3){
                //System.out.println("In 3");
                list.viewList();
                if(list.getSize()==0){
                    System.out.println("No tasks to edit");
                }
                else {
                    int taskNum = editTask();
                    int found = warning(taskNum, list.getSize());
                    if (found == 1) {
                        String title3 = editTitle(taskNum);
                        String description3 = editDescrip(taskNum);
                        String date3 = editDate(taskNum);
                        int found1=inputCheckTitle(title3);
                        int found2=inputCheckDate(date3);
                        if(found1==1 && found2==1)
                            list.editItem(taskNum, title3, description3, date3);
                    }
                }
                operationMenu();
                menuNum= input.nextInt();
            }else

            if(menuNum==4){
                //System.out.println("In 4");
                list.viewList();
                if(list.getSize()==0){
                    System.out.println("No tasks to remove");
                }
                else {
                    int num4 = removal();
                    int found = warning(num4, list.getSize());
                    if(found==1)
                        list.removeItem(num4);
                }
                operationMenu();
                menuNum= input.nextInt();

            }else

            if(menuNum==5){
                //System.out.println("In 5");
                list.viewUncompleted();
                if(list.getSize()==0){
                    System.out.println("No tasks available");
                }
                else {

                    int num5 = tobeCompleted();
                    int found = warning(num5, list.getSize());
                    if(found==1)
                        list.markCompleted(num5);
                }
                operationMenu();
                menuNum= input.nextInt();
            }else

            if(menuNum==6){
                //System.out.println("In 6");
                int size=list.viewCompleted();
                if(size==0){
                    System.out.println("No tasks available");
                }
                else {
                    int num6 = tobeUnMarked();
                    int found1=list.checkUnmarked(num6);
                    if(found1==-1){
                        System.out.println("Task not found");
                    }
                    else {
                        int found = warning(num6, list.getSize());
                        if (found == 1)
                            list.UnmarkCompleted(num6);
                    }
                }
                operationMenu();
                menuNum= input.nextInt();
            }else

            if(menuNum==7){
                String file_name=file_write();
                list.writeFile(file_name);
                operationMenu();
                menuNum= input.nextInt();
            }
            else{
                menuNum=8;
            }
        }

    }

}
