package models.dao;

import models.MenWear;
import models.Products;
import org.junit.*;
import org.sql2o.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Sql20MenWearDaoTest {
    private static Connection conn;
    public static Sql20MenWearDao menWearDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://ec2-54-175-117-212.compute-1.amazonaws.com:5432/d7dmvoatoj65";
        Sql2o sql2o = new Sql2o(connectionString, "dymqwdieiyxasa", "9adaee6831da8fd00373e7c3af8dc3be71ade77364aef2fab38b92bab08f3e21");

//
//        String connectionString = "jdbc:postgresql://localhost:5432/cynix_test_database";
//        Sql2o sql2o = new Sql2o(connectionString, "linus", "mariano@9496");
        System.out.println("Connection Initialized");
        menWearDao=new Sql20MenWearDao(sql2o);
        conn=sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clear Database");
        menWearDao.clearAll();
    }
    @AfterClass
    public static void shutDown() throws Exception
    {
        conn.close();
        System.out.println("Connection Closed");
    }

    @Test
    public void create_savesObjectMenWearToTheDatabase()throws Exception {
        MenWear testWear=createMenWear();
        menWearDao.create(testWear);
        assertEquals(1,menWearDao.getAll().size());
    }

    @Test
    public void getAll_getsAllMenWearFromTheDatabase()throws Exception {
        MenWear testWear=createMenWear();
        menWearDao.create(testWear);

        MenWear testSecondWear=createMenWear();
        menWearDao.create(testSecondWear);
        assertEquals(2,menWearDao.getAll().size());
    }

    @Test
    public void getById_getsMenWearFromTheDatabaseById()throws Exception {
        MenWear testWear=createMenWear();
        menWearDao.create(testWear);

        MenWear testSecondWear=createMenWear();
        menWearDao.create(testSecondWear);
        assertTrue(menWearDao.getById(testSecondWear.getId()).equals(testSecondWear));
    }

    @Test
    public void noNullValueIsReturned()throws Exception {
        assertEquals(0,menWearDao.getAll().size());
    }

    @Test
    public void clearAll_emptyMenWearList()throws Exception {
        MenWear testWear=createMenWear();
        menWearDao.create(testWear);

        MenWear testSecondWear=createMenWear();
        menWearDao.create(testSecondWear);
        menWearDao.clearAll();
        assertEquals(0,menWearDao.getAll().size());
    }

    @Test
    public void removeById_RemovesSpecificMenWear()throws Exception {
        MenWear testWear=createMenWear();
        menWearDao.create(testWear);

        MenWear testSecondWear=createMenWear();
        menWearDao.create(testSecondWear);

        menWearDao.deleteById(testSecondWear.getId());
        assertEquals(1,menWearDao.getAll().size());
    }
    //    helper
public MenWear createMenWear(){
    return new MenWear("Khaki","Blue",43);
}
}