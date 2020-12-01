public class ContactItem {
    public String first_name;
    public String last_name;
    public String phone;
    public String email;

    public String getFirst_name(){
        return this.first_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getEmail(){return this.email;}

    public void setFirst_name(String t){
        first_name=t;
    }
    public void setLast_name(String d){
        last_name=d;
    }
    public void setPhone(String num){
        phone=num;
    }
    public void setEmail(String e){
        email=e;
    }
    public String toString(){
        return first_name+" "+last_name+" "+phone+" "+email;
    }


}
