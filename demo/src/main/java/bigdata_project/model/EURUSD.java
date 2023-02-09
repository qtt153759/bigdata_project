package bigdata_project.model;

public class EURUSD extends Topic implements LIVE_INDEX{
    public EURUSD(String name, String interval) {
        super(name, interval);
    }

    @Override
    public String getUrl() {
        return "https://www.freeforexapi.com/api/live?pairs=EURUSD";
    }
    @Override
    public String getName() {
        return this.name;
    }
    public Double getValue(String response) {
//        String value=response.substring(response.indexOf("e\":")+3,response.indexOf(",\"timestamp"));
        return Double.valueOf(response);
    }

}
