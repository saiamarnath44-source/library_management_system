public class ReferenceBook extends Libraryitem {
    private String  author;
    public ReferenceBook(String title,String id, String author) {
        super(title, id);
        this.author=author;
    }
    @Override
    public void getstatus(){
         //print not available for borowing
    }


}
