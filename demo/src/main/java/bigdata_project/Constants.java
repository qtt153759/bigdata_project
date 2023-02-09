package bigdata_project;

import bigdata_project.model.*;

public class Constants {
    public static final String BROKER = "http://127.0.0.1:9092 , http://127.0.0.1:9093";
    public static final String SCHEMA_REGISTRY_URL = "http://127.0.0.1:8081";
    public static final String KEY_ALPHAVANTAGE = "QDUPH6Q4VXXU16GG";

    public static final String LIVE_TOPIC="LIVE_TOPICS";
    public static final Topic[] BATCH_TOPICS = new Topic[]{
            new Topic("REAL_GDP","quarterly"),
            new Topic("REAL_GDP_PER_CAPITA","quarterly"),
            new Topic("DURABLES","monthly"),
            new Topic("CPI","monthly"),
            new Topic("INFLATION","annual"),
            new Topic("RETAIL_SALES","monthly"),
            new Topic("UNEMPLOYMENT","monthly"),
            new Topic("NONFARM_PAYROLL","monthly"),
            new Treasury_yield("Treasury_yield","daily","10year")
    };

    public static final LIVE_INDEX[] STREAMING_TOPICS=new LIVE_INDEX[]{
            new EURUSD("EUR_USD_EXCHANGE","seconds"),
//            new OIL("OIL_PRICE","seconds"),
//            new Mental("MENTAL_PRICE","seconds"),
    };

    public static final String[] TICKERS = {"MMM", "ABT", "ABBV", "ACN", "ATVI", "AYI", "ADBE", "AAP", "AES", "AET"};
    public static final int MAX_PRICE_CHANGE = 5;

    public static final int START_PRICE = 5000;
    public static final int DELAY = 100;

}
