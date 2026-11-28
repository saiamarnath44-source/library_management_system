
import java.util.*;

public abstract class Members {

    private String name;
    private String id;
    private List<Libraryitem> borroweditems = new ArrayList<>();

    public Members(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract int getmaxitems();

    public abstract int getloanperiod();

    public void Borrow(Libraryitem item, Library _library) throws ItemNotAvailableException, BorrowLimitExceededException {

        if (item.getstatus().equals("NOT_BORROWABLE")) {
            throw new ItemNotAvailableException("cannot be borrowed", item.getid()); 
        }else if (item.getstatus().startsWith("ON_LOAN")) {
            throw new ItemNotAvailableException("item on loan", item.getid()); 
        }else if (this.borroweditems.size() >= this.getmaxitems()) {
            throw new BorrowLimitExceededException("item limit reached ", this.id, this.getmaxitems()); 
        }else {
            borroweditems.add(item);
            if (item instanceof Book) {
                ((Book) item).isborrowed(this, _library);
                System.out.println("OK due on day " + ((Book) item).getdueday(_library));
            } else {
                ((Magazine) item).isborrowed(this, _library);
                System.out.println("OK due on day " + ((Magazine) item).getdueday(_library));
            }
        }
    }

    public void Return(String item_id) {
        borroweditems.removeIf(i -> i.getid().equals(item_id));
    }

    public void showloans(Library _library) {
        if (borroweditems.isEmpty()) {
            System.out.println("NONE");
            return;
        }
        List<Libraryitem> sorted = new ArrayList<>(borroweditems);
        sorted.sort((a, b) -> {
            int da = _library.getdue(a);
            int db = _library.getdue(b);
            if (da != db) {
                return da - db;
            }
            return a.getid().compareTo(b.getid());
        });
        for (Libraryitem item : sorted) {
            System.out.println(item.getid() + "|" + item.gettitle() + "|" + _library.getdue(item));
        }
    }

    public String getid() {
        return this.id;
    }

}
