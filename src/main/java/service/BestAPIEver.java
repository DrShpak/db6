package service;

import connection.PostgresDAO;
import models.*;

import java.util.List;

public class BestAPIEver {
    private final PostgresDAO dao;

    public BestAPIEver(PostgresDAO dao) {
        this.dao = dao;
    }

    public List<Recipe> selectRecipes() {
        return dao.selectRecipes();
    }

    public List<Ingredient> selectIngredients() {
        return dao.selectIngredients();
    }

    public List<Literature> selectLiterature() {
        return dao.selectLiterature();
    }

    public List<RecipeComposition> selectComposition() {
        return dao.selectRecipeCompositions();
    }

    public List<RecipeLiterature> selectRecipeLiterature() {
        return dao.selectRecipeLiterature();
    }

    public void deleteRecipe(int recipeId) {
        dao.deleteRecipe(recipeId);
    }

    public void deleteLiterature(int literatureId) {
        dao.deleteLiterature(literatureId);
    }

    public void updateRecipe(Recipe recipe) {
        dao.updateRecipe(recipe);
    }

    public void updateLiterature(Literature literature) {
        dao.updateLiterature(literature);
    }
}