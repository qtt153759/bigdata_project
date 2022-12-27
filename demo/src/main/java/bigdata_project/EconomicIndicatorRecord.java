package bigdata_project;

import java.util.Date;

public class EconomicIndicatorRecord {
  double value;
  Date date;

  public EconomicIndicatorRecord(Date date, double value) {
    this.date = date;
    this.value = value;
  }

  @Override
  public String toString() {
    return "EconomicIndicatorRecord{" +
        "date='" + date + '\'' +
        ", value=" + value + '}';
  }
}
