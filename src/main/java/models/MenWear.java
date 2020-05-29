package models;

public class MenWear extends Products {
    private static final String CATEGORY="Men Wear";

    public MenWear(String name,String  color,int size) {
        this.name=name;
        this.color=color;
        this.size=size;
        this.category=CATEGORY;
    }
}
