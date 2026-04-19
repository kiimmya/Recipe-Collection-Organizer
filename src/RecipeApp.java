import java.util.*;

public class RecipeApp {
    private static List<Recipe> recipes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        recipes = FileManager.load();

        while (true) {
            showMenu();
            String command = scanner.nextLine().trim().toLowerCase();

            try {
                switch (command) {
                    case "1":
                    case "add":
                    case "a":
                        addRecipe();
                        break;
                    case "2":
                    case "view":
                    case "v":
                        viewRecipes();
                        break;
                    case "3":
                    case "update":
                    case "u":
                        updateRecipe();
                        break;
                    case "4":
                    case "delete":
                    case "d":
                        deleteRecipe();
                        break;
                    case "5":
                    case "exit":
                    case "e":
                        FileManager.save(recipes);
                        System.out.println("Data is saved. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid command!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // MENU
    private static void showMenu() {
        System.out.println("\n~~~~~ RECIPE ORGANIZER ~~~~~");
        System.out.println("\n   COMMAND MENU");
        System.out.println("1. Add Recipe (A)");
        System.out.println("2. View Recipes (V)");
        System.out.println("3. Update Recipe (U)");
        System.out.println("4. Delete Recipe (D)");
        System.out.println("5. Exit (E)");
        System.out.print("Choose: ");
    }

    // CREATE
    private static void addRecipe() {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Recipe recipe = new Recipe(name, category);

        while (true) {
            System.out.print("Ingredient name (or 'done'): ");
            String ingName = scanner.nextLine();
            if (ingName.equalsIgnoreCase("done")) break;

            System.out.print("Amount (grams/pcs): ");
            String amount = scanner.nextLine();

            recipe.addIngredient(new Ingredient(ingName, amount));
        }

        System.out.print("Enter recipe description: ");
        String description = scanner.nextLine();
        recipe.setDetails(new RecipeDetails(description));

        recipes.add(recipe);
        System.out.println("Recipe added!");
    }

    // VIEW
    private static void viewRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes found.");
            return;
        }

        System.out.println("\n RECIPES LIST");
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " (" + r.getCategory() + ")");
        }

        System.out.print("\nEnter recipe number to view details (or 0 to go back): ");
        String input = scanner.nextLine();

        if (input.equals("0")) return;

        try {
            int index = Integer.parseInt(input) - 1;

            if (index < 0 || index >= recipes.size()) {
                System.out.println("Invalid index!");
                return;
            }

            System.out.println("\n RECIPE DETAILS");
            recipes.get(index).display();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }

    // UPDATE
    private static void updateRecipe() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes to update.");
            return;
        }

        System.out.println("\n RECIPES");
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " (" + r.getCategory() + ")");
        }

        System.out.print("Enter recipe number: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid index!");
            return;
        }

        Recipe r = recipes.get(index);

        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. Ingredients");
        System.out.println("4. Description");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("New name: ");
                r.setName(scanner.nextLine());
                break;

            case "2":
                System.out.print("New category: ");
                r.setCategory(scanner.nextLine());
                break;

            case "3":
                r.clearIngredients();
                while (true) {
                    System.out.print("Ingredient (or 'stop'): ");
                    String name = scanner.nextLine();
                    if (name.equalsIgnoreCase("stop")) break;

                    System.out.print("Amount: ");
                    String amount = scanner.nextLine();

                    r.addIngredient(new Ingredient(name, amount));
                }
                break;

            case "4":
                System.out.print("New description: ");
                String newDesc = scanner.nextLine();
                r.setDetails(new RecipeDetails(newDesc));
                break;

            default:
                System.out.println("Invalid choice!");
        }

        System.out.println("Recipe updated!");
    }

    // DELETE
    private static void deleteRecipe() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes to delete.");
            return;
        }

        System.out.println("\n RECIPES");
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " (" + r.getCategory() + ")");
        }

        System.out.print("Enter recipe number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid index!");
            return;
        }

        recipes.remove(index);
        System.out.println("Deleted successfully!");
    }
}