package bigdata_project.model;

import bigdata_project.Constants;

public class Topic {
    public String name;
    public String interval;
    public Topic(String name,String interval){
        this.name=name;
        this.interval=interval;
    }

    public String getUrl(){
        String url="https://www.alphavantage.co/query?function=" + this.name + "&interval=" + this.interval + "&apikey=" + Constants.KEY_ALPHAVANTAGE;
        return url;
    }
    public String getName(){
        return this.name;
    }
}
