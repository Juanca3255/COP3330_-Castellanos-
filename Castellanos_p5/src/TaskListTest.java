import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;

public class TaskListTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        TaskItem item=new TaskItem();
        assertEquals(-1, TaskApp.inputCheckDate("20201-10-25"));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem item=new TaskItem();
        assertEquals(-1, TaskApp.inputCheckTitle(""));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem item=new TaskItem();
        assertEquals(1, TaskApp.inputCheckDate("2020-10-24"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem item=new TaskItem();
        assertEquals(1, TaskApp.inputCheckTitle("Task1"));
    }
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList list=new TaskList();
        assertEquals(0, list.getSize());
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        assertEquals(1, list.getSize());
    }
    @Test
    public void completingTaskItemChangesStatus(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        list.markCompleted(0);
        assertEquals(item.getCompleted(), "***");
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        assertEquals(-1,TaskApp.warning(1, list.getSize()));
    }
    @Test
    public void editingTaskItemChangesValues(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        list.editItem(0, "task2", "Second task", "2020-11-12");
        assertEquals("task2", item.getTitle());
        assertEquals("Second task", item.getDescription());
        assertEquals("2020-11-12", item.getDate());
    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        list.editItem(0, "task2", "Edited Task", "2020-10-24");
        assertEquals("task2", item.getTitle());
        assertEquals("Edited Task", item.getDescription());
        assertEquals("2020-10-24", item.getDate());
    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        assertEquals(-1,TaskApp.warning(4, list.getSize()));
    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        list.editItem(0, "Task1", "Edited Task", "2020-12-31");
        assertEquals("2020-12-31", item.getDate());
    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        list.editItem(0, "Task3", "Edited Task", "2020-10-24");
        assertEquals("Task3", item.getTitle());
    }
    @Test
    public void newTaskListIsEmpty(){
        TaskList list=new TaskList();
        assertEquals(0,list.getSize());
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        TaskItem item2=new TaskItem();
        item2.setTitle("Task2");
        item2.setDue_date("2020-11-24");
        item2.setDescription("Second Task");
        item2.setCompleted("");
        list.addItem(item2);
        assertEquals(2,list.getSize());
        list.removeItem(0);
        assertEquals(1, list.getSize());
    }
    @Test
    public void savedTaskListCanBeLoaded() throws FileNotFoundException {
        TaskList list=new TaskList();
        assertEquals(null,list.loadFile("test.txt"));
    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList list=new TaskList();
        TaskItem item=new TaskItem();
        item.setTitle("Task1");
        item.setDue_date("2020-10-24");
        item.setDescription("First Task");
        item.setCompleted("");
        list.addItem(item);
        list.markCompleted(0);
        assertEquals("***", item.getCompleted());
        list.UnmarkCompleted(0);
        assertEquals("",item.getCompleted());
    }

}
