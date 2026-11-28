
public class ReferenceBook extends Libraryitem {

    private String author;

    public ReferenceBook(String title, String id, String author) {
        super(title, id);
        this.author = author;
    }

    @Override
    public String getstatus() {
        return "NOT_BORROWABLE";
    }

    @Override
    public String gettype() {
        return "REFERENCE";
    }

}
