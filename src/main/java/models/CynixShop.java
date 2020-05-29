package models;

import java.util.Objects;

public class CynixShop {
    public int id;
    public String name;
    public String buildingName;
    public String shopNumber;
    public String email;
    public String phone;

    public CynixShop(String name, String buildingName, String shopNumber, String email, String phone) {
        this.name = name;
        this.buildingName = buildingName;
        this.shopNumber = shopNumber;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CynixShop cynixShop = (CynixShop) o;
        return Objects.equals(name, cynixShop.name) &&
                Objects.equals(buildingName, cynixShop.buildingName) &&
                Objects.equals(shopNumber, cynixShop.shopNumber) &&
                Objects.equals(email, cynixShop.email) &&
                Objects.equals(phone, cynixShop.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, buildingName, shopNumber, email, phone);
    }
}
