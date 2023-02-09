package bigdata_project.model;

import java.util.Date;

public class EconomicIndicatorRecord {
  public String value;
  public Date date;

  public EconomicIndicatorRecord(Date date, String value) {
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
