public abstract class Libraryitem{
    private String title;
    private String id;
    Libraryitem(String title,String id){
        this.title=title;
        this.id=id;
    }
    public abstract void getstatus();
    public String gettitle(){
        return title;
    }
    public String getid(){
        return id;
    }
}
