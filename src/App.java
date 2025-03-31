public class App {
    public static void main(String[] args) {
        Warehouse warehouse=new Warehouse("src/warehouse.txt");
        Product product=new Product("name", "11.22.33", "11.22.33", "ivan", 2,21, "popovo", "comment");
        warehouse.addProduct(product);
        warehouse.removeProduct("name", 10);
        warehouse.printProducts();


    }
}
