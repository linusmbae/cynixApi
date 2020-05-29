package models;

import java.util.Objects;

public abstract class Products {
    public int id;
    public String name;
    public String color;
    public int size;
    public String category;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return size == products.size &&
                Objects.equals(name, products.name) &&
                Objects.equals(color, products.color) &&
                Objects.equals(category, products.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, size, category);
    }
}
