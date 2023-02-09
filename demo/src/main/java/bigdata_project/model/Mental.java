package bigdata_project.model;

public class Mental extends Topic implements LIVE_INDEX{
    public Mental(String name, String interval) {
        super(name, interval);
    }

    @Override
    public String getUrl() {
        return "https://data-asg.goldprice.org/dbXRates/USD";
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Double getValue(String response) {
        String value=response.substring(response.indexOf("ce\":")+5,response.indexOf(",\"xag"));
        return Double.valueOf(value);
    }
}
