import java.io.Serializable;

public class RecipeDetails implements Serializable {
    private String description;

    public RecipeDetails(String description) {
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty!");
        }
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}