import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> products = new ArrayList<>();
    private String filePath;

    public Warehouse() {
    }

    public void open(String filePath) {
        this.filePath = filePath;
        products.clear();
        loadFromFile(filePath);
    }

    public void save() {
        if (filePath == null) {
            System.out.println("No file is open.");
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                writer.println(product.toTxt());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    public void saveAs(String newPath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(newPath))) {
            for (Product product : products) {
                writer.println(product.toTxt());
            }
            System.out.println("Saved to: " + newPath);
        } catch (IOException e) {
            System.out.println("Error saving to new file: " + e.getMessage());
        }
    }

    public void close() {
        products.clear();
        filePath = null;
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addProduct(Product product) {
        for (Product existing : products) {
            if (existing.getName().equalsIgnoreCase(product.getName()) &&
                    existing.getExpirationDate().equalsIgnoreCase(product.getExpirationDate())) {
                existing.reduceQuantity(-product.getQuantity());
                saveToFile();
                return;
            }
        }
        products.add(product);
        saveToFile();
    }

    public void removeProduct(String name, double quantity) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName().equalsIgnoreCase(name)) {
                if (product.getQuantity() >= quantity) {
                    product.reduceQuantity(quantity);
                    if (product.getQuantity() == 0) {
                        products.remove(products.get(i));
                    }
                    saveToFile();
                    return;
                }
            }
        }
        System.out.println("Product not found");
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

    private void loadFromFile(String filePath) {
        File file = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(Product.fromTxt(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }


}
