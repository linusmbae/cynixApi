package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CynixShopTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Cynix_instantiates_true()throws Exception {
        CynixShop testShop=createShop();
        assertTrue(testShop instanceof CynixShop);
    }

    @Test
    public void getName_returnsName()throws Exception {
        CynixShop testShop=createShop();
        assertEquals("Cynix",testShop.getName());
    }

    @Test
    public void getBuildingName_returnsBuildingName()throws Exception {
        CynixShop testShop=createShop();
        assertEquals("Tsavo",testShop.getBuildingName());
    }

    @Test
    public void getShopNumber_returnsShopNumber()throws Exception {
        CynixShop testShop=createShop();
        assertEquals("B20",testShop.getShopNumber());
    }

    @Test
    public void getEmail_returnsEmail()throws Exception {
        CynixShop testShop=createShop();
        assertEquals("cynix@gmail.com",testShop.getEmail());
    }

    @Test
    public void getPhone_returnsName()throws Exception {
        CynixShop testShop=createShop();
        assertEquals("+254714717625",testShop.getPhone());
    }

    //    Helper
    public CynixShop createShop()
    {
        return new CynixShop("Cynix","Tsavo","B20","cynix@gmail.com","+254714717625");
    }
}