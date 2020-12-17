import connection.PostgresDAO;
import models.Recipe;
import service.BestAPIEver;

public class Main {

    public static void main(String[] args) {
        var lol = new BestAPIEver(new PostgresDAO());

        lol.selectRecipes().forEach(System.out::println);

        lol.updateRecipe(new Recipe(2, "lol", 100, 356));
    }
}
