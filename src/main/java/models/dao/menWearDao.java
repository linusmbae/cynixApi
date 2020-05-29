package models.dao;

import models.MenWear;

import java.util.List;

public interface menWearDao {
//    create
    void create(MenWear menWear);

//    read
    List<MenWear> getAll();
    MenWear getById(int id);

//    update
    void update(int id, String name,String  color,int size,String category);

//    destroy
    void deleteById(int id);
    void clearAll();
}
