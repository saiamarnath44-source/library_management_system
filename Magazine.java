
public class Magazine extends Libraryitem implements Borrowable {

    private String issue;
    private int takenday = 0;
    private Boolean isavailable = true;
    private Members _member;
    private Library _library;

    public Magazine(String title, String id, String issue) {
        super(title, id);
        this.issue = issue;
    }

    @Override
    public int getfine() {
        return 1;
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
        return "MAGAZINE";
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
