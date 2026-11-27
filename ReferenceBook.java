public class ReferenceBook extends Libraryitem {
    private String  author;
    public ReferenceBook(String author) {
        super(null, null);
        this.author=author;
    }
    @Override
    public void getstatus(){
         //print not available for borowing
    }


}
