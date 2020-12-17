package models;

public class RecipeComposition {
    private int recipeId;
    private int ingredientId;
    private int count;

    public RecipeComposition(int recipeId, int ingredientId, int count) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.count = count;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}