package bigdata_project;

public class Constants {
    public static final String BROKER = "http://127.0.0.1:9092";
    public static final String SCHEMA_REGISTRY_URL = "http://127.0.0.1:8081";
    public static final String KEY_ALPHAVANTAGE = "QDUPH6Q4VXXU16GG";
    public static final Topic[] TOPICS = new Topic[]{
            new Topic("REAL_GDP","quarterly"),
            new Topic("REAL_GDP_PER_CAPITA","quarterly"),
//            new Topic("FEDERAL_FUNDS_RATE","daily"),
            new Topic("DURABLES","monthly"),
            new Topic("CPI","monthly"),
            new Topic("INFLATION","annual"),
            new Topic("RETAIL_SALES","monthly"),
            new Topic("UNEMPLOYMENT","monthly"),
//            new Topic("NONFARM_PAYROLL","monthly"),
    };

}
