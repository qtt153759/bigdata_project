package bigdata_project;

public class EconomicIndicator {
  EconomicIndicatorRecord[] data;
  String name;
  String interval;

  public EconomicIndicator(String name, EconomicIndicatorRecord[] data, String interval) {
    this.data = data;
    this.name = name;
    this.interval = interval;
  }

  public EconomicIndicatorRecord[] getdata() {
    return data;
  }

  @Override
  public String toString() {
    return "EconomicIndicator{" +
        "name='" + name + '\'' +
        ", interval=" + interval + '}';
  }
}
