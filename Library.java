
import java.util.*;

public class Library {

    private Map<String, Libraryitem> items = new HashMap<>();
    private Map<String, Members> members = new HashMap<>();
    private int day = 0;
    private List<String> duelist = new ArrayList<>();
    private List<String> borrowed_notdue = new ArrayList<>();

    public int getday() {
        return day;
    }

    public void advancedays(int n) {
        day += n;
        Iterator<String> it = borrowed_notdue.iterator();
        while (it.hasNext()) {
            String id = it.next();
            if (day > getdue(items.get(id))) {
                duelist.add(id);
                it.remove();
            }
        }
        System.out.println("OK today is day " + day);
    }

    public void addmember(String mem_id, Members member) {
        //add to map
        members.put(mem_id, member);
        System.out.println("OK");
    }

    public void additem(String item_id, Libraryitem item) {
        //add to map
        items.put(item_id, item);
        System.out.println("OK");
    }

    public void search(String text) {
        String key = text.toLowerCase();
        List<Libraryitem> found = new ArrayList<>();
        for (Libraryitem item : items.values()) {
            if (item.gettitle().toLowerCase().contains(key)) {
                found.add(item);
            }
        }
        if (found.isEmpty()) {
            System.out.println("NONE");
            return;
        }
        found.sort((a, b) -> {
            int c = a.gettitle().compareTo(b.gettitle());
            if (c != 0) {
                return c;
            }
            return a.getid().compareTo(b.getid());
        });
        for (Libraryitem item : found) {
            System.out.println(item.getid() + "|" + item.gettype() + "|" + item.gettitle());
        }
    }

    public void getoverduelist() {
        if (duelist.isEmpty()) {
            System.out.println("NONE");
            return;
        }
        List<String> sorted = new ArrayList<>(duelist);
        sorted.sort((a, b) -> {
            int la = day - getdue(items.get(a));
            int lb = day - getdue(items.get(b));
            if (la != lb) {
                return lb - la;
            }
            return a.compareTo(b);
        });
        for (String s : sorted) {
            Libraryitem item = items.get(s);
            int late = day - getdue(item);
            int fine = ((Borrowable) item).gettotalfine();
            System.out.println(s + "|" + getborrower(item) + "|" + late + "|" + fine);
        }
    }

    public void showinventory() {
        if (items.isEmpty()) {
            System.out.println("NONE");
            return;
        }
        for (String s : new TreeSet<>(items.keySet())) {
            Libraryitem item = items.get(s);
            System.out.println(s + "|" + item.gettype() + "|" + item.getstatus());
        }

    }

    public Members get_member(String id) throws MemberNotFoundException {
        for (String s : members.keySet()) {
            if (s.equals(id)) {
                return members.get(s);
            }
        }
        throw new MemberNotFoundException("no member with  the given id", id);
    }

    public Libraryitem get_item(String id) throws ItemNotFoundException {
        for (String s : items.keySet()) {
            if (s.equals(id)) {
                return items.get(s);
            }
        }
        throw new ItemNotFoundException("no item with the given id", id);
    }

    public void addborrowed(String item_id) {
        borrowed_notdue.add(item_id);
    }

    public void removeborrowed(String item_id) {
        borrowed_notdue.remove(item_id);
        duelist.remove(item_id);
    }

    public int getdue(Libraryitem item) {
        if (item instanceof Book) {
            return Integer.parseInt(((Book) item).getdueday(this));
        }
        return Integer.parseInt(((Magazine) item).getdueday(this));
    }

    public String getborrower(Libraryitem item) {
        if (item instanceof Book) {
            return ((Book) item).getmemberid();
        }
        return ((Magazine) item).getmemberid();
    }
}
