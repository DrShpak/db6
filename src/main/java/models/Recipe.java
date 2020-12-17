package models;

public class Recipe {
    private int recipeId;
    private String recipeName;
    private int cookingTime;
    private int calorificValue;

    public Recipe(int recipeId, String recipeName, int cookingTime, int calorificValue) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.calorificValue = calorificValue;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setCalorificValue(int calorificValue) {
        this.calorificValue = calorificValue;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getCalorificValue() {
        return calorificValue;
    }
}
