public class Product {
    private String name;
    private String expirationDate;
    private String entryDate;
    private String manufacturer;
    private double unit;
    private double quantity;

    private String location;

    private String comment;

    public Product(String name, String expirationDate, String entryDate, String manufacturer,
                   double unit, double quantity, String location, String comment) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.entryDate = entryDate;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.quantity = quantity;
        this.location = location;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void reduceQuantity(double quantityAmountToReduce) {
        this.setQuantity(this.quantity - quantityAmountToReduce);
    }


    @Override
    public String toString() {
        return "Product:" +
                "Name='" + name + '\'' +
                ", ExpirationDate='" + expirationDate + '\'' +
                ", EntryDate='" + entryDate + '\'' +
                ", Manufacturer='" + manufacturer + '\'' +
                ", Unit=" + unit +
                ", Quantity=" + quantity +
                ", Location='" + location + '\'' +
                ", Comment='" + comment + '\'';
    }

    public String toTxt() {
        return name + "|" + expirationDate + "|" + entryDate + "|" + manufacturer + "|" + unit + "|" + quantity + "|" + location + "|" + comment;
    }

    public static Product fromTxt(String line) {
        String[] parts = line.split("\\|");
        return new Product(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), parts[6], parts[7]);

    }

}
