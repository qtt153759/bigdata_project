package bigdata_project.model;

public class OIL extends Topic implements LIVE_INDEX {
    public OIL(String name, String interval) {
        super(name, interval);
    }
    @Override
    public String getUrl() {
        return "https://quote.cnbc.com/quote-html-webservice/restQuote/symbolType/symbol?symbols=%40CL.1&requestMethod=itv&noform=1&partnerId=2&fund=1&exthrs=1&output=json&events=1";
    }
    @Override
    public String getName() {
        return this.name;
    }
    public Double getValue(String response) {
        response=response.replaceAll("\\s+","");
        String value=response.substring(response.indexOf("settlePrice\":")+13,response.indexOf(",\"settleDate"));
        return Double.valueOf(value);
    }
}
