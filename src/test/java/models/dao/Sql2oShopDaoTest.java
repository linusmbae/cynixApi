package models.dao;

import models.CynixShop;
import models.MenWear;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oShopDaoTest {
    private static Connection conn;
    private static Sql2oShopDao shopDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://ec2-54-175-117-212.compute-1.amazonaws.com:5432/d7dmvoatoj65";
        Sql2o sql2o = new Sql2o(connectionString, "dymqwdieiyxasa", "9adaee6831da8fd00373e7c3af8dc3be71ade77364aef2fab38b92bab08f3e21");

//        String connectionString = "jdbc:postgresql://localhost:5432/cynix_test_database";
//        Sql2o sql2o = new Sql2o(connectionString, "linus", "mariano@9496");
        System.out.println("Connection Initialized");
        shopDao=new Sql2oShopDao(sql2o);
        conn=sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clear Database");
        shopDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception
    {
        conn.close();
        System.out.println("Connection Closed");
    }

    @Test
    public void create_savesObjectCynixShopToTheDatabase()throws Exception {
        CynixShop testShop=createShop();
        shopDao.create(testShop);
        assertEquals(1,shopDao.getAll().size());
    }

    @Test
    public void getAll_getsAllShopsFromTheDatabase()throws Exception {
        CynixShop testShop=createShop();
        shopDao.create(testShop);

        CynixShop testSecondShop=createShop();
        shopDao.create(testSecondShop);
        assertEquals(2,shopDao.getAll().size());
    }

    @Test
    public void getById_getsShopFromTheDatabaseById()throws Exception {
        CynixShop testShop=createShop();
        shopDao.create(testShop);

        CynixShop testSecondShop=createShop();
        shopDao.create(testSecondShop);
        assertTrue(shopDao.getById(testSecondShop.getId()).equals(testSecondShop));
    }

    @Test
    public void noNullValueIsReturned()throws Exception {
        assertEquals(0,shopDao.getAll().size());
    }

    @Test
    public void clearAll_emptyMenWearList()throws Exception {
        CynixShop testShop=createShop();
        shopDao.create(testShop);

        CynixShop testSecondShop=createShop();
        shopDao.create(testSecondShop);

        shopDao.clearAll();
        assertEquals(0,shopDao.getAll().size());
    }

    @Test
    public void removeById_RemovesSpecificMenWear()throws Exception {
        CynixShop testShop=createShop();
        shopDao.create(testShop);

        CynixShop testSecondShop=createShop();
        shopDao.create(testSecondShop);

        shopDao.deleteById(testSecondShop.getId());
        assertEquals(1,shopDao.getAll().size());
    }

    //    Helper
    public CynixShop createShop()
    {
        return new CynixShop("Cynix","Tsavo","B20","cynix@gmail.com","+254714717625");
    }
}