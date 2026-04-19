import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "recipes.dat";

    public static void save(List<Recipe> recipes) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(recipes);
        } catch (IOException e) {
            System.out.println("Error saving data!");
        }
    }

    public static List<Recipe> load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Recipe>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}