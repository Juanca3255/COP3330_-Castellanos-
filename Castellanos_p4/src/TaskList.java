import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    public static ArrayList<TaskItem> list;
    public TaskList(){
        list=new ArrayList<TaskItem>();
    }

    public static void viewList(){
        System.out.println("Current Tasks");
        System.out.println("-------------");
        for(int i=0; i<list.size(); i++){
            System.out.println(i+") "+list.get(i).getCompleted()+" ["+list.get(i).getDate()+"] "+list.get(i).getTitle()+": "+list.get(i).getDescription());
        }
    }
    public static void addItem(TaskItem addition){
        list.add(addition);
    }
    public static void removeItem(int position){
        list.remove(position);
    }
    public static void editItem(int position, String title, String description, String date){
        list.get(position).setTitle(title);
        list.get(position).setDescription(description);
        list.get(position).setDue_date(date);
    }
    public static void viewUncompleted(){
        System.out.println("Uncompleted Tasks");
        App.dash();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getCompleted().equals("")){
                System.out.println(i+") "+list.get(i).getCompleted()+" ["+list.get(i).getDate()+"]"+list.get(i).getTitle()+": "+list.get(i).getDescription());
            }
        }
    }
    public static void markCompleted(int pos){
        list.get(pos).setCompleted("***");
    }
    public static int viewCompleted(){
        System.out.println("Completed Tasks");
        int counter=0;
        App.dash();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getCompleted().equals("***")){
                counter++;
                System.out.println(i+") ["+list.get(i).getDate()+"]"+list.get(i).getTitle()+": "+list.get(i).getDescription());
            }
        }
        return counter;
    }
    public static void UnmarkCompleted(int pos){
        list.get(pos).setCompleted("");
    }
    public static int getSize(){
        return list.size();
    }
    public static int checkUnmarked(int pos){
        int found=1;
        for(int i=0;i<list.size(); i++){
            if(pos==i && list.get(i).getCompleted().equals("")){
                found=-1;
                break;
            }
        }
        return found;
    }
    public static void writeFile(String file_name) throws IOException {
        File file=new File(file_name);
        BufferedWriter out=new BufferedWriter(new FileWriter(file));
        for(int i=0; i<list.size(); i++){
            out.write(list.get(i).getCompleted());
            out.newLine();
            out.write(list.get(i).getDate());
            out.newLine();
            out.write(list.get(i).getTitle());
            out.newLine();
            out.write(list.get(i).getDescription());
            out.newLine();
            //out.write("end of task");
        }
        out.close();
        System.out.println("task list has been saved");
    }
    public static TaskList loadFile(String file_name) throws FileNotFoundException {
        TaskList upload = new TaskList();
        try {
            File file = new File(file_name);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                //System.out.println(reader.nextLine());

                String complicated = reader.nextLine();
                String date = reader.nextLine();
                String title = reader.nextLine();
                String description = reader.nextLine();
                TaskItem item = new TaskItem();
                item.setCompleted(complicated);
                item.setDue_date(date);
                item.setTitle(title);
                item.setDescription(description);
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

