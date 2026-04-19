import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class RecipeGUI extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> recipeList;
    private JTextArea detailsArea;

    private List<Recipe> recipes;

    public RecipeGUI() {
        recipes = FileManager.load();

        setTitle("Recipe Organizer");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // LIST
        listModel = new DefaultListModel<>();
        recipeList = new JList<>(listModel);
        refreshList();

        JScrollPane listScroll = new JScrollPane(recipeList);
        listScroll.setPreferredSize(new Dimension(250, 0));

        add(listScroll, BorderLayout.WEST);

        // DETAILS
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);

        add(new JScrollPane(detailsArea), BorderLayout.CENTER);

        // BUTTONS
        JPanel panel = new JPanel();

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        add(panel, BorderLayout.SOUTH);

        // EVENTS

        // Select recipe → show details
        recipeList.addListSelectionListener(e -> {
            int index = recipeList.getSelectedIndex();
            if (index >= 0) {
                showDetails(index);
            }
        });

        // Add
        addBtn.addActionListener(e -> addRecipe());

        // Update
        updateBtn.addActionListener(e -> updateRecipe());

        // Delete
        deleteBtn.addActionListener(e -> deleteRecipe());

        setVisible(true);
    }

    // REFRESH LIST
    private void refreshList() {
        listModel.clear();
        for (Recipe r : recipes) {
            listModel.addElement(r.getName() + " (" + r.getCategory() + ")");
        }
    }

    // SHOW DETAILS
    private void showDetails(int index) {
        Recipe r = recipes.get(index);

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(r.getName()).append("\n");
        sb.append("Category: ").append(r.getCategory()).append("\n\n");
        sb.append("Ingredients:\n");

        for (Ingredient i : r.getIngredients()) {
            sb.append(" - ").append(i.toString()).append("\n");
        }

        detailsArea.setText(sb.toString());
    }

    // ADD
    private void addRecipe() {
        String name = JOptionPane.showInputDialog("Enter recipe name:");
        if (name == null || name.trim().isEmpty()) return;

        String category = JOptionPane.showInputDialog("Enter category:");
        if (category == null || category.trim().isEmpty()) return;

        Recipe recipe = new Recipe(name, category);

        while (true) {
            String ingName = JOptionPane.showInputDialog("Ingredient (Cancel to stop):");
            if (ingName == null) break;

            String amount = JOptionPane.showInputDialog("Amount:");
            if (amount == null) break;

            recipe.addIngredient(new Ingredient(ingName, amount));
        }

        recipes.add(recipe);
        FileManager.save(recipes);
        refreshList();
    }

    // UPDATE
    private void updateRecipe() {
        int index = recipeList.getSelectedIndex();
        if (index < 0) return;

        Recipe r = recipes.get(index);

        String[] options = {"Name", "Category", "Ingredients"};
        int choice = JOptionPane.showOptionDialog(null,
                "What to update?",
                "Update",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        switch (choice) {
            case 0:
                String newName = JOptionPane.showInputDialog("New name:", r.getName());
                if (newName != null && !newName.trim().isEmpty()) {
                    r.setName(newName);
                }
                break;

            case 1:
                String newCat = JOptionPane.showInputDialog("New category:", r.getCategory());
                if (newCat != null && !newCat.trim().isEmpty()) {
                    r.setCategory(newCat);
                }
                break;

            case 2:
                r.clearIngredients();
                while (true) {
                    String ingName = JOptionPane.showInputDialog("Ingredient (Cancel to stop):");
                    if (ingName == null) break;

                    String amount = JOptionPane.showInputDialog("Amount:");
                    if (amount == null) break;

                    r.addIngredient(new Ingredient(ingName, amount));
                }
                break;
        }

        FileManager.save(recipes);
        refreshList();
        showDetails(index);
    }

    // DELETE
    private void deleteRecipe() {
        int index = recipeList.getSelectedIndex();

        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Please select a recipe first!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Delete this recipe?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            recipes.remove(index);
            FileManager.save(recipes);
            refreshList();
            detailsArea.setText("");
        }
    }
    //MAIN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RecipeGUI::new);
    }
}