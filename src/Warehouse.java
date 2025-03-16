import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> products = new ArrayList<>();
    private String filePath;

    public Warehouse(String filePath) {
        this.filePath = filePath;
        loadFromFile();
    }

    public void addProduct(Product product) {
        products.add(product);
        saveToFile();
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                writer.println(product.toTxt());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(Product.fromTxt(line));
            }
        } catch (IOException e) {
            System.out.println("No existing data found.");
        }
    }

}
