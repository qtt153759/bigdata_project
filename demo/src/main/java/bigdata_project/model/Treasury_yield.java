package bigdata_project.model;

import bigdata_project.Constants;

public class Treasury_yield extends Topic{

    public Treasury_yield(String name, String interval,String maturity) {
        super(name, interval);
        this.maturity=maturity;
    }
    public String maturity;

    @Override
    public String getUrl() {
        String url = "https://www.alphavantage.co/query?function=" + this.name + "&interval=" + this.interval+"&maturity="+this.maturity+"&apikey=" + Constants.KEY_ALPHAVANTAGE;
        return url;
    }
}
