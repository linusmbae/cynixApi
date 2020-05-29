package models.dao;

import models.CynixShop;
import models.MenWear;
import org.sql2o.*;

import java.util.List;

public class Sql2oShopDao implements shopDao {
    private final Sql2o sql2o;

    public Sql2oShopDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void create(CynixShop cynixShop) {
        String save="INSERT INTO cynix_shop(name, buildingName, shopNumber, email, phone)VALUES(:name, :buildingName, :shopNumber, :email, :phone)";
        try(Connection conn=sql2o.open()) {
            int id =(int) conn.createQuery(save,true)
                    .bind(cynixShop)
                    .executeUpdate()
                    .getKey();
            cynixShop.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public List<CynixShop> getAll() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM cynix_shop")
                    .executeAndFetch(CynixShop.class);
        }
    }

    @Override
    public CynixShop getById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM cynix_shop WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(CynixShop.class);
        }
    }

    @Override
    public void update(int id, String name, String buildingName, String shopNumber, String email, String phone) {
        String updateDepartment="UPDATE cynix_shop SET name, buildingName, shopNumber, email, phone WHERE id=:id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(updateDepartment)
                    .addParameter("name",name)
                    .addParameter("buildingName",buildingName)
                    .addParameter("shopNumber",shopNumber)
                    .addParameter("email",email)
                    .addParameter("phone",phone)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql ="DELETE FROM cynix_shop WHERE id=:id";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql ="DELETE FROM cynix_shop";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(sql)
                    .executeUpdate();

        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }
}
