
public class Staff extends Members {

    public Staff(String name, String id) {
        super(name, id);
    }

    @Override
    public int getmaxitems() {
        return 4;
    }

    @Override
    public int getloanperiod() {
        return 21;
    }

}
