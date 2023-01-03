package bigdata_project;

public class Treasury_yield extends Topic{

    Treasury_yield(String name, String interval,String maturity) {
        super(name, interval);
        this.maturity=maturity;
    }
    public String maturity;
}
