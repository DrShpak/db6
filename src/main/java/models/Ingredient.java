package models;

public class Ingredient {
    private int ingredientId;
    private String ingredientName;
    private String measure;

    public Ingredient(int ingredientId, String ingredientName, String measure) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.measure = measure;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
