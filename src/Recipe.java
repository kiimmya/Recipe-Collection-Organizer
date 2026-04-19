import java.util.ArrayList;
import java.util.List;

public class Recipe extends Item {
    private String category;
    private List<Ingredient> ingredients;
    private RecipeDetails details;

    public Recipe(String name, String category) {
        super(name);
        setCategory(category);
        this.ingredients = new ArrayList<>();
        this.details = new RecipeDetails("No description yet.");
    }

    // CATEGORY
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty!");
        }
        this.category = category;
    }

    // INGREDIENTS
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void clearIngredients() {
        ingredients.clear();
    }

    // DETAILS (DESCRIPTION)
    public RecipeDetails getDetails() {
        return details;
    }

    public void setDetails(RecipeDetails details) {
        if (details == null) {
            throw new IllegalArgumentException("Details cannot be null!");
        }
        this.details = details;
    }

    @Override
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Category: " + category);

        System.out.println("\nIngredients:");
        for (Ingredient i : ingredients) {
            System.out.println("  - " + i);
        }

        System.out.println("\nDescription:");
        System.out.println(details.getDescription());
    }
}