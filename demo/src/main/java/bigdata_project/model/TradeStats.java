package bigdata_project.model;

public class TradeStats {
    String type; int countTrades; double sumPrice,minPrice,avgPrice,maxPrice;
    public TradeStats add(Trade trade) {
        if (trade.type == null)
            throw new IllegalArgumentException("Invalid trade to aggregate: " + trade.toString());
        if (this.type == null)
            this.type = trade.type;
        if (!this.type.equals(trade.type))
            throw new IllegalArgumentException("Aggregating stats for trade type " + this.type + " but recieved trade of type " + trade.type);
        if (countTrades == 0) this.minPrice = trade.price;
        this.countTrades = this.countTrades + 1;
        this.sumPrice = this.sumPrice + trade.price;
        this.minPrice = this.minPrice < trade.price ? this.minPrice : trade.price;
        this.maxPrice = this.maxPrice > trade.price ? this.maxPrice : trade.price;
        return this;
    }
    public TradeStats computeAvgPrice() {
        this.avgPrice = this.sumPrice / this.countTrades;
        return this;
    }
}
