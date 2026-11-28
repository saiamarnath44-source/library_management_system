
public class Book extends Libraryitem implements Borrowable {

    private String author;
    private int takenday = 0;
    private Boolean isavailable = true;
    private Members _member;
    private Library _library;   // NEW: remembers the library so gettotalfine()/isreturned() can read the current day

    public Book(String title, String id, String author) {
        super(title, id);
        this.author = author;
    }

    @Override
    public int getfine() {
        return 2;
    }

    @Override
    public int gettotalfine() {
        int topay = 0;
        if (_member == null || _library == null) {
            return topay;
        }
        int dueday = takenday + _member.getloanperiod();
        int today = _library.getday();
        if (today > dueday) {
            topay = (today - dueday) * getfine();
        }
        return topay;
    }

    @Override
    public String getstatus() {
        if (isavailable) {
            return "AVAILABLE";
        }
        return "ON_LOAN|" + _member.getid();
    }

    @Override
    public String gettype() {
        return "BOOK";
    }

    public Boolean getavailability() {
        return this.isavailable;
    }

    public String getmemberid() {
        return _member.getid();
    }

    public String getdueday(Library _library) {
        int day = this.takenday;
        day += _member.getloanperiod();
        return Integer.toString(day);
    }

    public void isborrowed(Members _member, Library _library) {
        this._member = _member;
        this._library = _library;
        this.takenday = _library.getday();
        this.isavailable = false;
        _library.addborrowed(this.getid());
    }

    public void isreturned() {
        this.isavailable = true;
        _member.Return(this.getid());
        System.out.println("OK fine " + this.gettotalfine());
        _library.removeborrowed(this.getid());
        this.takenday = 0;
        this._member = null;
    }

}
