import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private String amount;

    public Ingredient(String name, String amount) {
        setName(name);
        setAmount(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingredient name cannot be empty!");
        }
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        if (amount.trim().isEmpty()) {
            throw new IllegalArgumentException("Amount cannot be empty!");
        }
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + " - " + amount;
    }
}