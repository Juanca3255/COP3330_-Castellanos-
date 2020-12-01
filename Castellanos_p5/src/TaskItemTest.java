import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
public class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate(){
        TaskItem item=new TaskItem();
        int num=TaskApp.inputCheckDate("1-245-21");
        assertEquals(-1,num);
    }
    @Test
    public void constructorFailsWithInvalidTitle(){
        TaskItem item=new TaskItem();
        int num=TaskApp.inputCheckTitle("");
        assertEquals(-1,num);
    }
    @Test
    public void constructorSucceedsWithValidDueDate(){
        TaskItem item=new TaskItem();
        int num=TaskApp.inputCheckDate("1997-10-24");
        assertEquals(1,num);
    }
    @Test
    public void constructorSucceedsWithValidTitle(){
        TaskItem item=new TaskItem();
        int num=TaskApp.inputCheckTitle("Groceries");
        assertEquals(1,num);
    }
}
