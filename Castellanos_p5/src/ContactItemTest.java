import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        ContactItem item=new ContactItem();
        String first="";
        String last="";
        String email="";
        String phone="";
        int check=ContactApp.atLeast(first.length(), last.length(),phone.length(),email.length());
        assertEquals(-1,check);
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="";
        String phone="954-999-9999";
        int check=ContactApp.atLeast(first.length(), last.length(),phone.length(),email.length());
        assertEquals(1,check);
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem item=new ContactItem();
        String first="";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        int check=ContactApp.atLeast(first.length(), last.length(),phone.length(),email.length());
        assertEquals(1,check);
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        int check=ContactApp.atLeast(first.length(), last.length(),phone.length(),email.length());
        assertEquals(1,check);
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="";
        int check=ContactApp.atLeast(first.length(), last.length(),phone.length(),email.length());
        assertEquals(1,check);
    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        int check=ContactApp.atLeast(first.length(), last.length(),phone.length(),email.length());
        assertEquals(1,check);
    }
//All editing uses my ContactApp.atLeast()
    @Test
    public void testToString(){
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        item.setFirst_name(first);
        item.setLast_name(last);
        item.setPhone(phone);
        item.setEmail(email);
        assertEquals("Juan Camilo 954-999-9999 abc@gmail.com",item.toString());
    }

}
