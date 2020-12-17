package models;

public class RecipeLiterature {
    private int recipe_id;
    private int literature_id;
    private int page_number;

    public RecipeLiterature(int recipe_id, int literature_id, int page_number) {
        this.recipe_id = recipe_id;
        this.literature_id = literature_id;
        this.page_number = page_number;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getLiterature_id() {
        return literature_id;
    }

    public void setLiterature_id(int literature_id) {
        this.literature_id = literature_id;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }
}
