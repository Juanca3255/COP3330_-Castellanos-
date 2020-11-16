public class TaskItem {
    public String title;
    public  String description;
    public  String due_date;
    public  String completed="";

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getDate(){
        return this.due_date;
    }
    public void setTitle(String t){
        title=t;
    }
    public void setDescription(String d){
        description=d;
    }
    public void setDue_date(String date){
        due_date=date;
    }
    public String getCompleted(){
        return completed;
    }
    public void setCompleted(String str){
        this.completed=str;
    }
    public String toString(){
        return title+" "+description+" "+due_date;
    }
}
