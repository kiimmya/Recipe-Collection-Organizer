import java.util.ArrayList;
import java.util.List;

public class Recipe extends Item {
    private String category;
    private List<Ingredient> ingredients;

    public Recipe(String name, String category) {
        super(name);
        setCategory(category);
        ingredients = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty!");
        }
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void clearIngredients() {
        ingredients.clear();
    }

    @Override
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Category: " + category);
        System.out.println("Ingredients:");
        for (Ingredient i : ingredients) {
            System.out.println("  - " + i);
        }
    }
}