package org.example.machineCoding.restaurentMgmtSystem.models;

public class MenuItem extends BaseModel{
    private String name;
    private double price;
    private DietaryRequirement dietaryRequirement;
    private ItemType itemType;

    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DietaryRequirement getDietaryRequirement() {
        return dietaryRequirement;
    }

    public void setDietaryRequirement(DietaryRequirement dietaryRequirement) {
        this.dietaryRequirement = dietaryRequirement;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
