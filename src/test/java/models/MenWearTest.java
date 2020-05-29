package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenWearTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instanceIsCreated_true()throws Exception {
        MenWear testWear=createMenWear();
        assertTrue(testWear instanceof MenWear);
    }

    @Test
    public void getName_returnsName()throws Exception {
        MenWear testWear=createMenWear();
        assertEquals("Khaki",testWear.getName());
    }

    @Test
    public void getColor_returnsColor()throws Exception {
        MenWear testWear=createMenWear();
        assertEquals("Blue",testWear.getColor());
    }

    @Test
    public void getSize_returnsSize()throws Exception {
        MenWear testWear=createMenWear();
        assertEquals(43,testWear.getSize());
    }

    @Test
    public void getCategory_returnsCategory()throws Exception {
        MenWear testWear=createMenWear();
        assertEquals("Men Wear",testWear.getCategory());
    }

//    Helper
    public MenWear createMenWear(){
        return new MenWear("Khaki","Blue",43);
    }
}