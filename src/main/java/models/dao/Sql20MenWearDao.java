package models.dao;

import models.MenWear;
import org.sql2o.*;

import java.util.List;

public class Sql20MenWearDao implements menWearDao{
    private final Sql2o sql2o;

    public Sql20MenWearDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void create(MenWear menWear) {
        String save="INSERT INTO men_wear(name, color, size, category)VALUES(:name,:color,:size,:category)";
        try(Connection conn=sql2o.open()) {
            int id =(int) conn.createQuery(save,true)
                    .bind(menWear)
                    .executeUpdate()
                    .getKey();
            menWear.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }

    }

    @Override
    public List<MenWear> getAll() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM men_wear")
                    .executeAndFetch(MenWear.class);
        }
    }

    @Override
    public MenWear getById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM men_wear WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(MenWear.class);
        }
    }

    @Override
    public void update(int id, String name, String color, int size, String category) {
        String updateDepartment="UPDATE men_wear SET name=:name, color=:color, size=:size, category=:category WHERE id=:id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(updateDepartment)
                    .addParameter("name",name)
                    .addParameter("color",color)
                    .addParameter("size",size)
                    .addParameter("category",category)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql ="DELETE FROM men_wear WHERE id=:id";
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
        String sql ="DELETE FROM men_wear";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(sql)
                    .executeUpdate();

        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }
}
