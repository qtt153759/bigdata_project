package bigdata_project.model;

public class Trade {
    String type;
    double price;
    public Trade(String type,  double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
