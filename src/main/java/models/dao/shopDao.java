package models.dao;

import models.CynixShop;

import java.util.List;

public interface shopDao {
//    create
    void create(CynixShop cynixShop);

//    read
    List<CynixShop> getAll();
    CynixShop getById(int id);

//    update
    void update(int id,String name, String buildingName, String shopNumber, String email, String phone);

//    destroy
    void deleteById(int id);
    void clearAll();
}
