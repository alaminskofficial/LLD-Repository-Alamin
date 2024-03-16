package org.example.machineCoding.restaurentMgmtSystem.dtos;

public class GetMenuItemsRequestDto {
    private String dietaryRequirement;

    public String getDietaryRequirement() {
        return dietaryRequirement;
    }

    public void setDietaryRequirement(String dietaryRequirement) {
        this.dietaryRequirement = dietaryRequirement;
    }
}
