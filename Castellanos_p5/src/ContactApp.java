import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ContactList list;
        mainMenu();
        int num = input.nextInt();
        while (num != 3) {
            if (num == 1) {
                System.out.println("new contact list has been created");
                list = new ContactList();
                operationMenu(list);
                mainMenu();
                num = input.nextInt();
            }else
            if (num == 2) {
                String name = file_read();
                list = ContactList.loadFile(name);
                if(list.getSize()==0){
                    //mainMenu();
                }
                else
                    operationMenu(list);
                    mainMenu();
                    num = input.nextInt();

            }
            else
            if (num == 3) {
                break;
            }
        }
        Selection.main(null);
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
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
    }
    public static String addContactFirst_Name(){
        Scanner input=new Scanner(System.in);
        System.out.println("First name: ");
        String title2=input.nextLine();
        return title2;
    }
    public static String addContactLast_Name(){
        Scanner input=new Scanner(System.in);
        System.out.println("Last name: ");
        String description2=input.nextLine();
        return description2;
    }
    public static String addContactPhone(){
        Scanner input=new Scanner(System.in);
        System.out.println("Phone number (xxx-xxx-xxxx): ");
        String date2=input.nextLine();
        return date2;
    }
    public static String addContactEmail(){
        Scanner input=new Scanner(System.in);
        System.out.println("Email address (x@y.z): ");
        String date2=input.nextLine();
        return date2;
    }
    public static int editContact() {
        System.out.println("Which contact will you edit? ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        return num;
    }
    public static String editFirst_Name(int num){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a new first name for contact "+num+": ");
        String title=input.nextLine();
        return title;
    }
    public static String editLast_Name(int num){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a new last name for contact "+num+": ");
        String description=input.nextLine();
        return description;
    }
    public static String editPhone(int num){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a new phone number (xxx-xxx-xxxx) for contact "+num+": ");
        String date=input.nextLine();
        return date;
    }
    public static String editEmail(int num){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a new email address (x@y.z) for contact "+num+": ");
        String email=input.nextLine();
        return email;
    }
    public static int inputCheckPhone(String d){
        int found=0;
        if(d.length()!=12 || d.indexOf('-')!=3 ||
                d.indexOf('-',4)!=7){
            System.out.println("WARNING: invalid Phone Number; Contact not created");
            found=-1;
        }
        return found;
    }
    public static int removal(){
        Scanner input=new Scanner(System.in);
        System.out.println("Which contact will you remove? ");
        int num=input.nextInt();
        return num;
    }
    public static int warning(int num, int size){
        int not=1;
        if(num==size || num>size || num<0){
            System.out.println("WARNING: invalid input for Contact. Contact not found.");
            not=-1;
        }
        return not;
    }
    public static int atLeast(int f_length, int l_length, int p_length, int e_length){
        int pass=1;
        if(f_length==0 && l_length==0 && p_length==0 && e_length==0){
            pass=-1;
            System.out.println("At least a name, phone or email has to be entered per contact");
        }
        return pass;
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
    public static void operationMenu(ContactList list) throws IOException {
        Scanner input = new Scanner(System.in);

        operationMenu();
        int menuNum;
        menuNum = input.nextInt();
        while (menuNum != 6) {
            if(menuNum==0 || menuNum>6){
                System.out.println("These input are not accepted. Please try again. ");
                operationMenu();
                menuNum=input.nextInt();
            }
            else
            if (menuNum == 1) {
                list.viewList();
                operationMenu();
                menuNum= input.nextInt();
            }
            else
            if(menuNum==2){
                ContactItem addition=new ContactItem();
                String first=addContactFirst_Name();
                String last=addContactLast_Name();
                String phone=addContactPhone();
                String email=addContactEmail();
                int pass_phone=1;
                int pass=atLeast(first.length(), last.length(), phone.length(), email.length());
                if(phone.length()>0) {
                    pass_phone = inputCheckPhone(phone);
                    if (pass == 1 && pass_phone == 0) {
                        addition.setFirst_name(first);
                        addition.setLast_name(last);
                        addition.setPhone(phone);
                        addition.setEmail(email);
                        list.addItem(addition);
                    }
                }
                else{
                    if(pass == 1){
                        addition.setFirst_name(first);
                        addition.setLast_name(last);
                        addition.setPhone(phone);
                        addition.setEmail(email);
                        list.addItem(addition);
                    }
                }
                operationMenu();
                menuNum= input.nextInt();

            }else
            if(menuNum==3){
                //System.out.println("In 3");
                list.viewList();
                if(list.getSize()==0){
                    System.out.println("No Contacts to edit");
                }
                else {
                    int taskNum = editContact();
                    int found = warning(taskNum, list.getSize());
                    if (found == 1) {
                        String first_name3 = editFirst_Name(taskNum);
                        String last_name3 = editLast_Name(taskNum);
                        String phone3 = editPhone(taskNum);
                        String email3=editEmail(taskNum);
                        int pass_phone=1;
                        int pass=atLeast(first_name3.length(), last_name3.length(), phone3.length(), email3.length());
                        if(phone3.length()>0){
                            pass_phone=inputCheckPhone(phone3);
                            if (pass == 1 && pass_phone == 0) {
                                list.editItem(taskNum, first_name3,last_name3,phone3,email3);
                            }
                        }
                        else
                        if(pass==1)
                            list.editItem(taskNum, first_name3,last_name3,phone3,email3);
                    }
                }
                operationMenu();
                menuNum= input.nextInt();
            }else
            if(menuNum==4){
                list.viewList();
                if(list.getSize()==0){
                    System.out.println("No Contacts to remove");
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
                String file_name=file_write();
                list.writeFile(file_name);
                operationMenu();
                menuNum= input.nextInt();
            }
            else{
                if(menuNum==6)
                    break;
            }
        }

    }

}