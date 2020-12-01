import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    public static ArrayList<ContactItem> list;
    public ContactList(){
        list=new ArrayList<ContactItem>();
    }

    public static void viewList(){
        System.out.println("Current Contacts");
        System.out.println("-------------");
        for(int i=0; i<list.size(); i++){
            System.out.println(i+") Name: "+list.get(i).getFirst_name()+" "+list.get(i).getLast_name());
            System.out.println("Phone: "+list.get(i).getPhone());
            System.out.println("Email: "+list.get(i).getEmail());
        }
    }
    public static void addItem(ContactItem addition){
        list.add(addition);
    }
    public static void removeItem(int position){
        list.remove(position);
    }
    public static void editItem(int position, String first, String last, String phone, String email){
        list.get(position).setFirst_name(first);
        list.get(position).setLast_name(last);
        list.get(position).setPhone(phone);
        list.get(position).setEmail(email);
    }

    public static int getSize(){
        return list.size();
    }

    public static void writeFile(String file_name) throws IOException {
        File file=new File(file_name);
        BufferedWriter out=new BufferedWriter(new FileWriter(file));
        for(int i=0; i<list.size(); i++){
            out.write(list.get(i).getFirst_name());
            out.newLine();
            out.write(list.get(i).getLast_name());
            out.newLine();
            out.write(list.get(i).getPhone());
            out.newLine();
            out.write(list.get(i).getEmail());
            out.newLine();
        }
        out.close();
        System.out.println("Contact list has been loaded");
    }
    public static ContactList loadFile(String file_name) throws FileNotFoundException {
        ContactList upload = new ContactList();
        try {
            File file = new File(file_name);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String first = reader.nextLine();
                String last = reader.nextLine();
                String phone = reader.nextLine();
                String email = reader.nextLine();
                ContactItem item = new ContactItem();
                item.setFirst_name(first);
                item.setLast_name(last);
                item.setPhone(phone);
                item.setEmail(email);
                upload.addItem(item);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
        if(upload.getSize()!=0)
            return upload;
        else
            return null;

    }


}