package connection;

import models.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PostgresDAO {

    private final static String PATH_TO_QUERIES = "src/main/resources/queries.properties";
    private final static Properties properties = new Properties();

    static {
        try {
            //todo create queries.properties
            properties.load(new FileInputStream(PATH_TO_QUERIES));
        } catch (IOException e) {
            //todo log it
        }
    }

    private final ConnectionBuilder builder = new PostgresConnection();

    public List<Recipe> selectRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try (var con = builder.getConnection();
             var rs = con.createStatement().executeQuery(properties.getProperty("selectRecipes"))) {
//            var rs = stm.executeQuery();
            recipes = parseRecipes(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recipes;
    }

    private List<Recipe> parseRecipes(ResultSet rs) throws SQLException {
        List<Recipe> recipes = new ArrayList<>();
        while (rs.next()) {
            recipes.add(new Recipe(
                rs.getInt("recipe_id"),
                rs.getString("recipe_name"),
                rs.getInt("cooking_time"),
                rs.getInt("calorific_value")));
        }
        return recipes;
    }

    public List<Ingredient> selectIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("selectIngredients"))) {
            var rs = stm.executeQuery();
            ingredients = parseIngredients(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ingredients;
    }

    private List<Ingredient> parseIngredients(ResultSet rs) throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        while (rs.next()) {
            ingredients.add(new Ingredient(
                rs.getInt("ingredient_id"),
                rs.getString("ingredient_name"),
                rs.getString("measure")
            ));
        }
        return ingredients;
    }

    public List<Literature> selectLiterature() {
        List<Literature> literature = new ArrayList<>();
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("selectLiterature"))) {
            var rs = stm.executeQuery();
            literature = parseLiterature(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return literature;
    }

    private List<Literature> parseLiterature(ResultSet rs) throws SQLException {
        List<Literature> literature = new ArrayList<>();
        while (rs.next()) {
            literature.add(new Literature(
                rs.getInt("literature_id"),
                rs.getString("literature_name")
            ));
        }
        return literature;
    }

    public List<RecipeComposition> selectRecipeCompositions() {
        List<RecipeComposition> compositions = new ArrayList<>();
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("selectRecipeCompositions"))) {
            var rs = stm.executeQuery();
            compositions = parseCompositions(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return compositions;
    }

    private List<RecipeComposition> parseCompositions(ResultSet rs) throws SQLException {
        List<RecipeComposition> compositions = new ArrayList<>();
        while (rs.next()) {
            compositions.add(new RecipeComposition(
                rs.getInt("recipe_id"),
                rs.getInt("ingredient_id"),
                rs.getInt("count")
            ));
        }
        return compositions;
    }

    public List<RecipeLiterature> selectRecipeLiterature() {
        List<RecipeLiterature> recipeLiteratures = new ArrayList<>();
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("selectRecipeLiterature"))) {
            var rs = stm.executeQuery();
            recipeLiteratures = parseRecipeLiterature(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recipeLiteratures;
    }

    private List<RecipeLiterature> parseRecipeLiterature(ResultSet rs) throws SQLException {
        List<RecipeLiterature> compositions = new ArrayList<>();
        while (rs.next()) {
            compositions.add(new RecipeLiterature(
                rs.getInt("recipe_id"),
                rs.getInt("literature_id"),
                rs.getInt("page_number")
            ));
        }
        return compositions;
    }

    public void insertRecipe(Recipe recipe) {
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("insertRecipe"))) {
            //id autoincrement
            stm.setString(1, recipe.getRecipeName());
            stm.setInt(2, recipe.getCookingTime());
            stm.setInt(3, recipe.getCalorificValue());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLiterature(Literature literature) {
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("insertLiterature"))) {
            //id autoincrement
            stm.setString(1, literature.getLiteratureName());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecipe(int recipeId) {
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("deleteRecipe"))) {
            //delete recipe where id = recipeId
            stm.setInt(1, recipeId);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLiterature(int literatureId) {
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("deleteLiterature"))) {
            //delete literature where id = literatureId
            stm.setInt(1, literatureId);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecipe(Recipe recipe) {
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("updateRecipe"))) {
            stm.setString(1, recipe.getRecipeName());
            stm.setInt(2, recipe.getCookingTime());
            stm.setInt(3, recipe.getCalorificValue());
            stm.setInt(4, recipe.getRecipeId());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLiterature(Literature literature) {
        try (var con = builder.getConnection();
             var stm = con.prepareStatement(properties.getProperty("updateLiterature"))) {
            stm.setString(1, literature.getLiteratureName());
            stm.setInt(2, literature.getLiteratureId());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
