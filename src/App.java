import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Enter command (open, close, save, saveas, add, remove, print, help, exit): ");
            String command = scanner.nextLine().trim();

            switch (command.split(" ")[0].toLowerCase()) {
                case "open": {
                    String[] parts = command.split(" ", 2);
                    if (parts.length < 2) {
                        System.out.println("Usage: open <filepath>");
                        break;
                    }
                    File file = new File(parts[1]);
                    warehouse.open(parts[1]);
                    System.out.println("File opened successfully.");
                    break;
                }
                case "close": {
                    warehouse.close();
                    System.out.println("Warehouse closed.");
                    break;
                }
                case "save": {
                    warehouse.save();
                    break;
                }
                case "saveas": {
                    System.out.print("Enter new file path: ");
                    String newPath = scanner.nextLine();
                    warehouse.saveAs(newPath);
                    break;
                }
                case "add": {
                    System.out.print("Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Expiration Date: ");
                    String expDate = scanner.nextLine();
                    System.out.print("Entry Date: ");
                    String entryDate = scanner.nextLine();
                    System.out.print("Manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Unit: ");
                    double unit = Double.parseDouble(scanner.nextLine());
                    System.out.print("Quantity: ");
                    double quantity = Double.parseDouble(scanner.nextLine());
                    System.out.print("Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Comment: ");
                    String comment = scanner.nextLine();

                    Product product = new Product(name, expDate, entryDate, manufacturer, unit, quantity, location, comment);
                    warehouse.addProduct(product);
                    break;
                }
                case "remove": {
                    System.out.print("Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    double quantity = Double.parseDouble(scanner.nextLine());
                    warehouse.removeProduct(name, quantity);
                    break;
                }
                case "print": {
                    warehouse.printProducts();
                    break;
                }
                case "help": {
                    System.out.println("Available commands:");
                    System.out.println("open <filepath> - отваря файл със складови данни");
                    System.out.println("close - затваря текущия склад");
                    System.out.println("save - запазва файла");
                    System.out.println("save as - запазва в нов файл");
                    System.out.println("add - добавя продукт");
                    System.out.println("remove - премахва продукт по име и количество");
                    System.out.println("print - показва всички наличности");
                    System.out.println("help - показва този списък");
                    System.out.println("exit - изход от програмата");
                    break;
                }
                case "exit": {
                    isRunning = false;
                    break;
                }
                default:
                    System.out.println("Unknown command. Type 'help' for list of commands.");
            }
        }
    }
}
