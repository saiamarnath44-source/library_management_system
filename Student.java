
public class Student extends Members {

    public Student(String name, String id) {
        super(name, id);
    }

    @Override
    public int getmaxitems() {
        return 3;
    }

    @Override
    public int getloanperiod() {
        return 14;
    }
}
