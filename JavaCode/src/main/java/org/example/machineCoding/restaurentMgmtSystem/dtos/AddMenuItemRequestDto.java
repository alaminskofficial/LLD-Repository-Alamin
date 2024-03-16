package org.example.machineCoding.restaurentMgmtSystem.dtos;

public class AddMenuItemRequestDto {

    private long userId;
    private String name;
    private double price;
    private String dietaryRequirement;
    private String itemType;
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

    public String getDietaryRequirement() {
        return dietaryRequirement;
    }

    public void setDietaryRequirement(String dietaryRequirement) {
        this.dietaryRequirement = dietaryRequirement;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
