import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    public void testCalculate1(){
        BodyMassIndex a=new BodyMassIndex(68, 130);
        assertEquals(19.76,a.BMI_score);
    }

    @Test
    public void testCalculate2(){
        BodyMassIndex a=new BodyMassIndex(77, 195);
        assertEquals(23.12,a.BMI_score);
    }
    @Test
    public void testCalculate3(){
        BodyMassIndex a=new BodyMassIndex(60, 100);
        assertEquals(19.53,a.BMI_score);
    }
    @Test
    public void testCalculate4(){
        BodyMassIndex a=new BodyMassIndex(48, 50);
        assertEquals(15.26,a.BMI_score);
    }

    @Test
    public void testCategory1(){
       BodyMassIndex b=new BodyMassIndex(68,130);
       assertEquals("Normal weight", b.BMI_category);
    }
    @Test
    public void testCategory2(){
        BodyMassIndex b=new BodyMassIndex(77,195);
        assertEquals("Normal weight", b.BMI_category);
    }
    @Test
    public void testCategory3(){
        BodyMassIndex b=new BodyMassIndex(60,100);
        assertEquals("Normal weight", b.BMI_category);
    }
    @Test
    public void testCategory4(){
        BodyMassIndex b=new BodyMassIndex(48,50);
        assertEquals("Underweight", b.BMI_category);
    }



}