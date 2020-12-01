import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
public class ContactListTest {

    @Test
            public void addingItemsIncreasesSize(){
        ContactList list=new ContactList();
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        ContactItem item1=new ContactItem();
        String first1="James";
        String last1="Cam";
        String email1="def@gmail.com";
        String phone1="111-222-3333";
        ContactList.addItem(item);
        ContactList.addItem(item1);
        assertEquals(2,list.getSize());

    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList list=new ContactList();
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        item.setFirst_name(first);
        item.setLast_name(last);
        item.setPhone(phone);
        item.setEmail(email);
        ContactList.addItem(item);
        assertEquals(-1,ContactApp.warning(4,list.getSize()));
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList list=new ContactList();
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        item.setFirst_name(first);
        item.setLast_name(last);
        item.setPhone(phone);
        item.setEmail(email);
        ContactList.addItem(item);
        ContactList.editItem(0,"","Suarez","111-222-3333","nfd@hotmail.com");
        assertEquals("",item.getFirst_name());
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList list=new ContactList();
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        item.setFirst_name(first);
        item.setLast_name(last);
        item.setPhone(phone);
        item.setEmail(email);
        ContactList.addItem(item);
        ContactList.editItem(0,"James","","111-222-3333","nfd@hotmail.com");
        assertEquals("",item.getLast_name());
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList list=new ContactList();
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        item.setFirst_name(first);
        item.setLast_name(last);
        item.setPhone(phone);
        item.setEmail(email);
        ContactList.addItem(item);
        ContactList.editItem(0,"James","Suarez","","nfd@hotmail.com");
        assertEquals("",item.getPhone());
    }
    @Test
    public void newListIsEmpty(){
        ContactList list=new ContactList();
        assertEquals(0,list.getSize());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList list=new ContactList();
        ContactItem item=new ContactItem();
        String first="Juan";
        String last="Camilo";
        String email="abc@gmail.com";
        String phone="954-999-9999";
        ContactItem item1=new ContactItem();
        String first1="James";
        String last1="Cam";
        String email1="def@gmail.com";
        String phone1="111-222-3333";
        ContactList.addItem(item);
        ContactList.addItem(item1);
        ContactList.removeItem(0);
        assertEquals(1,list.getSize());
    }
    @Test
    public void savedTaskListCanBeLoaded() throws FileNotFoundException {
        ContactList list=new ContactList();
        assertEquals(null,list.loadFile("test.txt"));
    }

}
