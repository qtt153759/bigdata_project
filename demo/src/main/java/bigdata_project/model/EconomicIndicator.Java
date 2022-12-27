package bigdata_project.model;

public class EconomicIndicator {
  Date date;
  double value;
  String type;
  public EconomicIndicator(String type,Date date, double value) {
        this.date = date;
        this.value = value;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EconomicIndicator{" +
                "type='" + type + '\'' +
                ", date=" + date + '\'' +
                ", value='" + value +'}';
    }
}
